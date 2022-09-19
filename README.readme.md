# Product Store


### API test validate for products in cart

#### For understanding the code, images are attached in the folder [moreInfo](moreInfo).
#### 1. On the product page we select [Inspect](moreInfo/1.jpg).
#### 2. On the html page we select the match div and [copy element](moreInfo/2.jpg).
#### 3. We create html page, we have the data inside [info](moreInfo/3.jpg) as here: [html](moreInfo/main.html).
#### 4. Parsing from html file to temporary json object.
#### 5. The data save as json file.
#### 6. Aggregation the data to unified java object model.
#### 7. Test and validate on the object.


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
