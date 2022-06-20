<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" import="shopmart.models.*, java.util.ArrayList, shopmart.dao.*"%>
<!DOCTYPE html>
<html>
   <head>
      <!-- Basic -->
      <meta charset="utf-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge" />
      <!-- Mobile Metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
      <!-- Site Metas -->
      <meta name="keywords" content="" />
      <meta name="description" content="" />
      <meta name="author" content="" />
      <link rel="shortcut icon" href="images/logo.jpg" type="">
      <title>ShopMart</title>
      <!-- bootstrap core css -->
      <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
      <!-- font awesome style -->
      <link href="css/font-awesome.min.css" rel="stylesheet" />
      <!-- Custom styles for this template -->
      <link href="css/style.css" rel="stylesheet" />
      <!-- responsive style -->
      <link href="css/responsive.css" rel="stylesheet" />
   </head>
   <body class="sub_page">
   	<%
   		ProductDao dao = new ProductDao();
	   	ArrayList<Product> products = new ArrayList<Product>();
    	products.addAll(dao.getProductsByCatagory("Men").subList(3, 7));
    	products.addAll(dao.getProductsByCatagory("Women").subList(3, 7));
    	products.addAll(dao.getProductsByCatagory("Kid").subList(3, 7));
   	%>
      <div class="hero_area">
         <!-- header section strats -->
         <header class="header_section">
            <div class="container">
               <nav class="navbar navbar-expand-lg custom_nav-container ">
                  <a class="navbar-brand" href="https://bpcit-shopmart.herokuapp.com"><img width="170" src="images/logo.jpg" alt="#" /></a>
                  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                  <span class=""> </span>
                  </button>
                  <div class="collapse navbar-collapse" id="navbarSupportedContent">
                     <ul class="navbar-nav">
                        <li class="nav-item">
                           <a class="nav-link" href="https://bpcit-shopmart.herokuapp.com">Home <span class="sr-only">(current)</span></a>
                        </li>
                        
                        <li class="nav-item active">
                           <a class="nav-link" href="products.jsp">Products</a>
                        </li>
                        <li class="nav-item">
                           <a class="nav-link" href="blogs.jsp">Blog</a>
                        </li>
                     </ul>
                  </div>
               </nav>
            </div>
         </header>
         <!-- end header section -->
      </div>
      <!-- inner page section -->
      <section class="inner_page_head">
         <div class="container_fuild">
            <div class="row">
               <div class="col-md-12">
                  <div class="full">
                     <h3>Product Wardrop</h3>
                  </div>
               </div>
            </div>
         </div>
      </section>
      <!-- end inner page section -->
      <!-- product section -->
      <section class="product_section layout_padding">
         <div class="container">
            <div class="heading_container heading_center">
               <h2>
                  Our <span>products</span>
               </h2>
            </div>
            <div class="row">
               <%
               for (int i = 0; i < products.size(); i++) {
               Product product = products.get(i);
               %>
               <div class="col-sm-6 col-md-4 col-lg-3">
                  <div class="box">
                     <div class="option_container">
                        <div class="options">
                           <a href="product?productId=<%=product.getProductID()%>" class="option2">
                              view
                           </a>
                        </div>
                     </div>
                     <div class="img-box">
                        <img src="images/products/<%=product.getProductID()%>.jpeg" alt="">
                     </div>
                     <div class="detail-box">
                        <h5>
                           <%=product.getCatagory()%>'s <%=product.getType()%>
                        </h5>
                        <h6>RS. <%=product.getPrice()%></h6>
                     </div>
                  </div>
               </div>
               <% } %>
            </div>
         </div>
      </section>
      <!-- end product section -->
     </body>
</html>