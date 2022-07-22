import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import {
  Button,
  Card,
  Container,
  Form,
  FormGroup,
  Input,
  Label,
} from "reactstrap";

const Login = () => {
  const [isValid, setIsValid] = useState(false);
  const [user, setUser] = useState([]);

  const navigate = useNavigate();

  const validateUser = async (event) => {
    const { name, password } = event.target;
    let exist= false;

  user.forEach(users =>{
      if (users.name.includes(name.value) && users.password.includes(password.value)) {
        return exist = true;
      }
    })

    if (exist) {
      navigate("/home");
    }
  };

  useEffect(() => {
    fetch("/api/user/")
      .then((response) => response.json())
      .then((data) => {
        setUser(data);
      });
  }, []);

  return (
    <Container className=" col-6 p-5 justify-content-center">
      <h2 className="mb-5">Login</h2>
      <Card className="p-4 shadow-sm">
        <Form onSubmit={validateUser}>
          <FormGroup className="mb-2 me-sm-2 mb-sm-0">
            <Label className="me-sm-2" for="name">
              User Name
            </Label>
            <Input id="name" name="name" placeholder="User Name" type="name" />
          </FormGroup>
          <FormGroup className="mt-2 me-sm-2 mb-sm-0">
            <Label className="me-sm-2" for="password">
              Password
            </Label>
            <Input
              id="password"
              name="password"
              placeholder="don't tell!"
              type="password"
            />
          </FormGroup>
          <Button color="primary" className="mt-2" type="submit">
            Submit
          </Button>
        </Form>
      </Card>
    </Container>
  );
};

export default Login;
