import { Link, useNavigate, useParams } from "react-router-dom";
import {
  Button,
  Container,
  FormGroup,
  Input,
  Label,
  Form,
  Row,
  Col,
  Card,
  Collapse,
  CardBody,
  ButtonGroup,
  Table,
} from "reactstrap";
import AppNavbar from "../nav/AppNavbar";
import { useEffect, useState } from "react";
import Moment from "react-moment";
import moment from "moment";

const ProductDetail = () => {
  const initialState = {
    itemCode: "",
    description: "",
    price: 0,
    estate: 0,
    createDate: moment.now(),
    creator: {},
    supplier: {},
    priceReductions: [],
  };

  const initprices = {
    price: 0,
    starDate: moment.now(),
    endDate: moment.now(),
  };
  const [products, setProducts] = useState(initialState);
  const [suppliers, setSuppliers] = useState([]);
  const [users, setUsers] = useState({});
  const [priceReductions, setPriceReductions] = useState(initprices);
  const [prices, setPrices] = useState([]);
  const [isDisabled, setIsDisabled] = useState(false);

  const [isOpen, setIsOpen] = useState(false);

  const toggle = () => setIsOpen(!isOpen);

  const navigate = useNavigate();
  const { id } = useParams();

  useEffect(() => {
    if (id !== "new") {
      fetch(`/api/products/${id}`)
        .then((response) => response.json())
        .then((data) => {
          setProducts(data);
          setPrices(data.priceReductions);
          setIsDisabled(true);
        });
    }

    fetch(`/api/user/${1}`)
      .then((response) => response.json())
      .then((data) => {
        setUsers(data);
      });

    fetch("/api/suppliers")
      .then((response) => response.json())
      .then((data) => {
        setSuppliers(data);
      });
  }, [id, setProducts]);



//Products
  const handleChange = (event) => {
    const { name, value } = event.target;

    products.creator = users;

    if (name === "supplier") {
      fetch(`/api/suppliers/${value}`)
        .then((response) => response.json())
        .then((data) => {
          return setProducts({ ...products, [name]: data });
        });
    }

    setProducts({ ...products, [name]: value });
  };



  const handleSubmit = async (event) => {
    event.preventDefault();

    if (products.estate == null) {
      products.estate = 0;
    }

    if (products.estate) {
      products.estate = parseInt(products.estate);
    }

    await fetch("/api/products" + (products.id ? "/" + products.id : ""), {
      method: products.id ? "PUT" : "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(products),
    });
    setProducts(initialState);
    navigate("/products");
  };


  //Price Reductions
  const priceReductionsHandler = (event) => {
    const { name, value } = event.target;

    setPriceReductions({ ...priceReductions, [name]: value });
  };
  const savePriceReduction = async () => {
    priceReductions.product_id = products.id;

    priceReductions.starDate = moment(priceReductions.starDate).format();
    priceReductions.endDate = moment(priceReductions.endDate).format();

    await fetch(
      "/api/priceReductions" +
        (priceReductions.id ? "/" + priceReductions.id : ""),
      {
        method: priceReductions.id ? "PUT" : "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify(priceReductions),
      }
    );
  };

  const priceReductionSection = (
    <div>
      <h3>Price Reductions</h3>
      <Table>
        <thead>
          <tr>
            <th>Price</th>
            <th>Start</th>
            <th>End</th>
          </tr>
        </thead>
        <tbody>
          {prices.map((price) => {
            return (
              <tr key={price.id}>
                <td>$ {price.price}</td>
                <td>
                  <Moment date={price.starDate} format="DD/MM/YYYY"></Moment>
                </td>
                <td>
                  <Moment date={price.endDate} format="DD/MM/YYYY"></Moment>
                </td>
                <td>
                  <Button className="float-end" color="danger" >
                    Delete
                  </Button>
                </td>
              </tr>
            );
          })}
        </tbody>
      </Table>
      <Button color="primary" onClick={toggle} style={{ marginBottom: "1rem" }}>
        Price Reductions +
      </Button>
      <Collapse isOpen={isOpen}>
        <Card>
          <CardBody>
            <Row>
              <Col md={2}>
                <Label>PriceReductions</Label>
                <Input
                  type="number"
                  name="price"
                  id="price"
                  value={priceReductions.price}
                  onChange={priceReductionsHandler}
                ></Input>
              </Col>

              <Col md={2}>
                <Label>PriceReductions</Label>
                <Input
                  type="date"
                  name="starDate"
                  id="starDate"
                  value={priceReductions.starDate}
                  onChange={priceReductionsHandler}
                ></Input>
              </Col>

              <Col md={2}>
                <Label>PriceReductions</Label>
                <Input
                  type="date"
                  name="endDate"
                  id="endDate"
                  value={priceReductions.endDate}
                  onChange={priceReductionsHandler}
                ></Input>
              </Col>
            </Row>

            <ButtonGroup className="mt-2" onClick={savePriceReduction}>
              <Button color="primary">Guardar</Button>
            </ButtonGroup>
          </CardBody>
        </Card>
      </Collapse>
    </div>
  );

  const title = <h2>{products.id ? "Edit Product" : "Add Product"}</h2>;
  return (
    <div>
      <AppNavbar />
      <Container className="">
        <Card body className="mt-2  mb-2 shadow-sm">
          {title}
          <Form>
            <Row>
              <Col md={2}>
                <FormGroup>
                  <Label for="itemCode">Item Code</Label>
                  <Input
                    type="text"
                    name="itemCode"
                    id="itemCode"
                    value={products.itemCode}
                    onChange={handleChange}
                    disabled={isDisabled}
                  />
                </FormGroup>
              </Col>
              <Col md={3}>
                <FormGroup>
                  <Label for="price">Price</Label>
                  <Input
                    type="number"
                    name="price"
                    id="price"
                    step={1}
                    value={products.price}
                    onChange={handleChange}
                  />
                </FormGroup>
              </Col>
              <Col md={6}>
                <FormGroup>
                  <Label>Description</Label>
                  <Input
                    type="text"
                    name="description"
                    id="description"
                    value={products.description}
                    onChange={handleChange}
                  ></Input>
                </FormGroup>
              </Col>
              <Col md={2}>
                <FormGroup>
                  <Label for="estate">State</Label>

                  <select
                    className="form-select"
                    type="select"
                    name="estate"
                    id="estate"
                    value={products.state}
                    onChange={handleChange}
                  >
                    <option value={0}>ACTIVE</option>
                    <option value={1}>DISCOTINUED</option>
                  </select>
                </FormGroup>
              </Col>
              <Col md={3}>
                <FormGroup>
                  <Label for="createDate">Create Date</Label>
                  <Input
                    type="text"
                    name="createDate"
                    id="createDate"
                    value={moment(products.createDate).format("DD/MM/YYYY")}
                    onChange={handleChange}
                    disabled={true}
                  ></Input>
                </FormGroup>
              </Col>
              <Col md={2}>
                <FormGroup>
                  <Label for="creator">Creator</Label>
                  <Input
                    type="text"
                    name="creator"
                    id="creator"
                    value={users.name}
                    onChange={handleChange}
                    disabled={true}
                  ></Input>
                </FormGroup>
              </Col>
              <Col md={4}>
                <FormGroup>
                  <Label>Supplier</Label>
                  <Input
                    type="select"
                    name="supplier"
                    id="supplier"
                    value={products.suppliers}
                    onBlurCapture={handleChange}
                  >
                    {suppliers.map((supplier, index) => {
                      return (
                        <option key={index} value={supplier.id}>
                          {supplier.name}
                        </option>
                      );
                    })}
                  </Input>
                </FormGroup>
              </Col>
              <Col md={12}>
                <div>{priceReductionSection}</div>
              </Col>

              <FormGroup className="mt-3">
                <Button color="primary" onClick={handleSubmit}>
                  Save
                </Button>{" "}
                <Button color="secondary" tag={Link} to="/products">
                  Cancel
                </Button>
              </FormGroup>
            </Row>
          </Form>
        </Card>
      </Container>
    </div>
  );
};

export default ProductDetail;
