import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Button, Form, Icon, Header, Popup, Modal } from 'semantic-ui-react';
import { useNavigate } from 'react-router-dom'; // Import useNavigate
import './BookManagement.css'; // Custom styles for the component

const BookManagement = () => {
  const [books, setBooks] = useState([]);
  const [isbn, setIsbn] = useState('');
  const [title, setTitle] = useState('');
  const [author, setAuthor] = useState('');
  const [publicationYear, setPublicationYear] = useState('');
  const [newTitle, setNewTitle] = useState('');
  const [updateModalOpen, setUpdateModalOpen] = useState(false);
  const [currentBook, setCurrentBook] = useState(null);
  const [popupOpen, setPopupOpen] = useState(false);

  const navigate = useNavigate(); // Initialize useNavigate

  useEffect(() => {
    fetchBooks();
  }, []);

  const fetchBooks = () => {
    const token = localStorage.getItem('token');
    axios.get('http://localhost:8080/api/admin/getAllBooks', {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    })
    .then(response => {
      setBooks(response.data);
    })
    .catch(error => {
      console.error('There was an error fetching the books!', error);
    });
  };

  const addBook = () => {
    const book = { isbn, title, author, publicationYear: parseInt(publicationYear, 10) };
    const token = localStorage.getItem('token');

    axios.post('http://localhost:8080/api/admin/addNewBook', book, {
      headers: {
        'Authorization': `Bearer ${token}`,
        'Content-Type': 'application/json',
      },
    })
    .then(response => {
      alert('Book added successfully');
      fetchBooks(); // Refresh book list
      setPopupOpen(false); // Close the popup
      // Reset input fields
      setIsbn('');
      setTitle('');
      setAuthor('');
      setPublicationYear('');
    })
    .catch(error => {
      console.error('There was an error adding the book!', error);
    });
  };

  const updateBook = () => {
    const token = localStorage.getItem('token');

    axios.put(`http://localhost:8080/api/admin/updateBook/${currentBook.isbn}/${newTitle}`, {}, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    })
    .then(response => {
      alert('Book updated successfully');
      fetchBooks(); // Refresh book list
      setUpdateModalOpen(false); // Close the update modal
    })
    .catch(error => {
      console.error('There was an error updating the book!', error);
    });
  };

  const removeBook = (isbn) => {
    const token = localStorage.getItem('token');

    axios.delete(`http://localhost:8080/api/admin/deleteBook/${isbn}`, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    })
    .then(response => {
      alert('Book removed successfully');
      fetchBooks(); // Refresh book list
    })
    .catch(error => {
      console.error('There was an error removing the book!', error);
    });
  };

  const logout = () => {
    localStorage.removeItem('token');
    navigate('/login'); // Redirect to login page
  };

  return (
    <div>
      <div className="top-bar">
        <Popup
          trigger={<Button icon labelPosition="left"><Icon name="add" /> Add Book</Button>}
          on="click"
          position="bottom center"
          open={popupOpen}
          onOpen={() => setPopupOpen(true)}
          onClose={() => setPopupOpen(false)}
        >
          <Header className="modal-header">Add New Book</Header>
          <Form>
            <Form.Input
              label="ISBN"
              value={isbn}
              onChange={e => setIsbn(e.target.value)}
              required
            />
            <Form.Input
              label="Title"
              value={title}
              onChange={e => setTitle(e.target.value)}
              required
            />
            <Form.Input
              label="Author"
              value={author}
              onChange={e => setAuthor(e.target.value)}
            />
            <Form.Input
              label="Publication Year"
              value={publicationYear}
              onChange={e => setPublicationYear(e.target.value)}
              required
            />
            <Button primary onClick={addBook}>Add Book</Button>
          </Form>
        </Popup>
        <Button icon labelPosition="left" onClick={logout}>
          <Icon name="sign-out" />
          Logout
        </Button>
      </div>

      <h1>Book Management</h1>

      <div className="table-container">
        <table>
          <thead>
            <tr>
              <th>ISBN</th>
              <th>Title</th>
              <th>Author</th>
              <th>Publication Year</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {books.map(book => (
              <tr key={book.isbn}>
                <td>{book.isbn}</td>
                <td>{book.title}</td>
                <td>{book.author}</td>
                <td>{book.publicationYear}</td>
                <td>
                  <Button icon className="update-button" onClick={() => {
                    setCurrentBook(book);
                    setUpdateModalOpen(true);
                  }}>
                    <Icon name="edit" />
                    Update
                  </Button>
                  <Button icon className="delete-button" onClick={() => removeBook(book.isbn)}>
                    <Icon name="delete" />
                    Delete
                  </Button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      {/* Update Book Modal */}
      <Modal open={updateModalOpen} onClose={() => setUpdateModalOpen(false)}>
        <Header className="modal-header">Update Book Title</Header>
        <Modal.Content className="modal-content">
          <Form>
            <Form.Input
              label="New Title"
              value={newTitle}
              onChange={e => setNewTitle(e.target.value)}
              required
            />
          </Form>
        </Modal.Content>
        <Modal.Actions className="modal-actions">
          <Button onClick={() => setUpdateModalOpen(false)}>Cancel</Button>
          <Button primary onClick={updateBook}>Update Book</Button>
        </Modal.Actions>
      </Modal>
    </div>
  );
};

export default BookManagement;
