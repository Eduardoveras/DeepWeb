<#include "layouts/header.ftl">
<body>
<#include "layouts/navigation.ftl">

 
  <!-- catg header banner section -->
  <section id="aa-catg-head-banner">
   <img src="img/fashion/fashion-header-bg-8.jpg" alt="fashion img">
   <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h2>Cart Page</h2>
        <ol class="breadcrumb">
          <li><a href="index.html">Home</a></li>                   
          <li class="active">Cart</li>
        </ol>
      </div>
     </div>
   </div>
  </section>
  <!-- / catg header banner section -->




 <!-- Cart view section -->
 <section id="cart-view">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
         <div class="cart-view-area">
          <#if shoppingCart?has_content >
           <div class="cart-view-table">
             <form action="">
               <div class="table-responsive">
                  <table class="table">
                    <thead>
                      <tr>
                        <th></th>
                        <th></th>
                        <th>Product</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total</th>
                      </tr>
                    </thead>
                    <tbody>
                      <#list shoppingCart as item>
                        <tr>
                          <td><a class="remove" href="#"><fa class="fa fa-close"></fa></a></td>
                          <td><a href="#"><img src="img/man/polo-shirt-1.png" alt="img"></a></td>
                          <td><a class="aa-cart-title" href="#">${item.getProductName()}</a></td>
                          <td>$${item.getProductPrice()}</td>
                          <td><input class="aa-cart-quantity" type="number" value="1"></td>
                          <td>$${item.getProductPrice()}</td>
                        </tr>
                      </#list>


                      <tr>
                        <td colspan="6" class="aa-cart-view-bottom">
                          <div class="aa-cart-coupon">
                            <input class="aa-coupon-code" type="text" placeholder="Coupon">
                            <input class="aa-cart-view-btn" type="submit" value="Apply Coupon">
                          </div>
                          <input class="aa-cart-view-btn" type="submit" value="Update Cart">
                        </td>
                      </tr>
                      </tbody>
                  </table>
                </div>
             </form>
             <!-- Cart Total view -->
             <div class="cart-view-total">
               <h4>Cart Totals</h4>
               <table class="aa-totals-table">
                 <tbody>
                   <tr>
                     <th>Subtotal</th>
                     <td>$450</td>
                   </tr>
                   <tr>
                     <th>Total</th>
                     <td>$450</td>
                   </tr>
                 </tbody>
               </table>
               <a href="#" class="aa-cart-view-btn">Proced to Checkout</a>
             </div>
           </div>
          <#else >
          <h1>YOU DONT HAVE ITEMS IN YOUR CART, ADD SOME!
          </#if>
         </div>
       </div>
     </div>
   </div>
 </section>
 <!-- / Cart view section -->

<#include "layouts/footer.ftl">