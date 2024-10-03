import React, { useState } from 'react';
import axios from 'axios';
import { Button, Form } from 'semantic-ui-react';
import './AddBook.css';

function AddBook({ fetchBooks }) {
  const [isbn, setIsbn] = useState('');
  const [title, setTitle] = useState('');
  const [author, setAuthor] = useState('');
  const [publicationYear, setPublicationYear] = useState('');

  const addBook = (e) => {
    e.preventDefault();
    const book = { isbn, title, author, publicationYear: parseInt(publicationYear, 10) };
    const token = localStorage.getItem('token');

    axios.post('http://localhost:8080/api/admin/addNewBook', book, {
      headers: {
        Authorization: `Bearer ${token}`,
        'Content-Type': 'application/json'
      }
    })
      .then(response => {
        alert('Book added successfully');
        fetchBooks();
      })
      .catch(error => {
        console.error('There was an error adding the book!', error);
      });
  };

  return (
    <div className="add-book-container">
      <h2>Add New Book</h2>
      <Form onSubmit={addBook}>
        <Form.Input
          type="number"
          placeholder="ISBN"
          value={isbn}
          onChange={(e) => setIsbn(e.target.value)}
          required
        />
        <Form.Input
          type="text"
          placeholder="Title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          required
        />
        <Form.Input
          type="text"
          placeholder="Author"
          value={author}
          onChange={(e) => setAuthor(e.target.value)}
        />
        <Form.Input
          type="number"
          placeholder="Publication Year"
          value={publicationYear}
          onChange={(e) => setPublicationYear(e.target.value)}
          required
        />
        <Button type="submit">Add Book</Button>
      </Form>
    </div>
  );
}

export default AddBook;
