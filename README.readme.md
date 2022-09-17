# Product Store


#### API test validate for products in cart


## Controller

### getId function:

    input:
       String path
       String id - return the last char in the path
The function call to the method getId() in service.

### getAllProducts function:

    input:
       String path
       List<StoreModel> - all the products
The function call to method htmlToJson() in service.


## Service

### getId function:

    input:
       String path
       String id - return the last char in the path
The function catch the URL and return the additional value (the id).

### htmlToJson function:

    input:
       String path
       List<StoreModel> - all the products
The function get path of html page and parse it to json file,
and create a list of products in order to make it unified.
And return all the products that exist in the cart.
