
import React, {Component} from 'react';
import Form from 'react-bootstrap/Form'
import Button from 'react-bootstrap/Button'
import './style.css'

class Registration extends Component {
handleSubmit= event =>{
  event.preventDefault();
  this.registerUser(event.target.username.value, event.target.password.value)
}

registerUser(username, passsword){
fetch('http://localhost:8080/users_login',{
method:'POST',
headers:{
  'Accept': 'application/json',
  'Content-Type': 'application/json'
},
body: JSON.stringify({
  username: username,
  password: passsword,
})
}).then(function(response){
  if(response.status===200){
    console.log("User registered")
  }
  else{
    console.log("User not register")
  }
}).catch(function(error){
  console.log("error");
}
)
}

  render() {
    return <div className='Register'>
      <Form onSubmit={this.handleSubmit}>
        <Form.Group controlId='username' size="lg">
          <Form.Label>Username</Form.Label>
          <Form.Control autoFocus name="username"></Form.Control>
        </Form.Group>

        <Form.Group controlId='password' size="lg">
          <Form.Label>Password</Form.Label>
          <Form.Control autoFocus name="passsword"></Form.Control>
        </Form.Group>
        <Button block size="lg" type="submit">Register</Button>
      </Form>
      </div>
  }
}

export default Registration;
