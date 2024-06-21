import React, { useState } from 'react';
import axios from 'axios';
import './App.css';

function App() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/auth/login', {
                username,
                password
            });
            console.log(response.data);
        } catch (error) {
            console.error('There was an error!', error);
        }
    };

    return (
        <div className="App">
            <form onSubmit={handleLogin}>
                <h2>Login</h2>
                <div>
                    <label>Username: </label>
                    <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} />
                </div>
                <div>
                    <label>Password: </label>
                    <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
                </div>
                <button type="submit">Login</button>
            </form>
        </div>
    );
}

export default App;
