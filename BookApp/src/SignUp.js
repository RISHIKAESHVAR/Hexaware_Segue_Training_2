import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import './SignUp.css';

function SignUp() {
  const [email, setSignupEmail] = useState('');
  const [password, setSignupPassword] = useState('');
  const [name, setName] = useState('');
  const [userRole, setUserRole] = useState('0'); 
  const navigate = useNavigate();

  const signupUser = (e) => {
    e.preventDefault();
    const signupData = {
      email: email,
      password: password,
      name: name,
      userRole: parseInt(userRole, 10)
    };

    axios.post('http://localhost:8080/api/auth/signup', signupData)
      .then(response => {
        alert('Signup successful! You can now log in.');
        navigate('/login');
      })
      .catch(error => {
        console.error('There was an error signing up!', error);
        alert('Signup failed! Please try again.');
      });
  };

  return (
    <div className="signup-container">
      <h1>Signup</h1>
      <form onSubmit={signupUser}>
        <div className="form-group">
          <label htmlFor="name">Name</label>
          <input
            type="text"
            id="name"
            placeholder="Name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="email">Email</label>
          <input
            type="email"
            id="email"
            placeholder="Email"
            value={email}
            onChange={(e) => setSignupEmail(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="password">Password</label>
          <input
            type="password"
            id="password"
            placeholder="Password"
            value={password}
            onChange={(e) => setSignupPassword(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="userRole">User Role</label>
          <select
            id="userRole"
            value={userRole}
            onChange={(e) => setUserRole(e.target.value)}
            required
          >
            <option value="0">Admin</option>
            <option value="1">User</option>
          </select>
        </div>
        <button type="submit" className="signup-button">Signup</button>
      </form>
    </div>
  );
}

export default SignUp;
