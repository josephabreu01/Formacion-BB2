import { Button, Container, NavLink } from "reactstrap";
import AppNavbar from "../nav/AppNavbar";
import { Link } from "react-router-dom";

const Home = () => {
  return (
    <div>
      <AppNavbar />
      <Container fluid>
        <Button color="link">
          <Link to={"/products"}>Productos List</Link>
        </Button>
      </Container>
    </div>
  );
};

export default Home;
