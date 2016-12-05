
<!-- wpf loader Two -->
<div id="wpf-loader-two">
    <div class="wpf-loader-two-inner">
        <span>Loading</span>
    </div>
</div>
<!-- / wpf loader Two -->
<!-- SCROLL TOP BUTTON -->
<a class="scrollToTop" href="#"><i class="fa fa-chevron-up"></i></a>
<!-- END SCROLL TOP BUTTON -->


<!-- Start header section -->
<header id="aa-header">
    <!-- start header top  -->
    <div class="aa-header-top">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="aa-header-top-area">
                        <!-- start header top left -->
                        <div class="aa-header-top-left">
                            <!-- start language -->
                            <div class="aa-language">
                                <div class="dropdown">
                                    <a class="btn dropdown-toggle" href="#" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                        <img src="img/flag/english.jpg" alt="english flag">ENGLISH
                                        <span class="caret"></span>
                                    </a>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                        <li><a href="#"><img src="img/flag/french.jpg" alt="">FRENCH</a></li>
                                        <li><a href="#"><img src="img/flag/english.jpg" alt="">ENGLISH</a></li>
                                    </ul>
                                </div>
                            </div>
                            <!-- / language -->

                            <!-- start currency -->
                            <div class="aa-currency">
                                <div class="dropdown">
                                    <a class="btn dropdown-toggle" href="#" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                        <i class="fa fa-usd"></i>USD
                                        <span class="caret"></span>
                                    </a>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                        <li><a href="#"><i class="fa fa-euro"></i>EURO</a></li>
                                        <li><a href="#"><i class="fa fa-jpy"></i>YEN</a></li>
                                    </ul>
                                </div>
                            </div>
                            <!-- / currency -->
                            <!-- start cellphone -->
                            <div class="cellphone hidden-xs">
                                <p><span class="fa fa-phone"></span>00-62-658-658</p>
                            </div>
                            <!-- / cellphone -->
                        </div>
                        <!-- / header top left -->
                        <div class="aa-header-top-right">
                            <ul class="aa-head-top-nav-right">
                                <li><a href="account.html">My Account</a></li>
                                <li class="hidden-xs"><a href="wishlist.html">Wishlist</a></li>
                                <li class="hidden-xs"><a href="cart.html">My Cart</a></li>
                                <li class="hidden-xs"><a href="checkout.html">Checkout</a></li>
                            <#if user??>
                                <li><a href="/logout">Logout</a></li>
                            <#else >
                                <li><a href="" data-toggle="modal" data-target="#login-modal">Login</a></li>
                            </#if>

                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- / header top  -->

    <!-- start header bottom  -->
    <div class="aa-header-bottom">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="aa-header-bottom-area">
                        <!-- logo  -->
                        <div class="aa-logo">
                            <!-- Text based logo -->
                            <a href="/">
                                <span class="fa fa-shopping-cart"></span>
                                <p>Amazon<strong>Platano</strong> <span>Your Shopping Partner</span></p>
                            </a>
                        </div>
                        <!-- / logo  -->
                        <!-- cart box -->
                        <div class="aa-cartbox">
                            <a class="aa-cart-link" href="/cart">
                                <span class="fa fa-shopping-basket"></span>
                                <span class="aa-cart-title">SHOPPING CART</span>
                                <span class="aa-cart-notify">${shoppingCart?size}</span>
                            </a>
                            <div class="aa-cartbox-summary">
                                <ul>
                                    <#list shoppingCart as item>
                                    <li>
                                        <a class="aa-cartbox-img" href="#"><img src="img/woman-small-2.jpg" alt="img"></a>
                                        <div class="aa-cartbox-info">
                                            <h4><a href="#">${item.getProductName()}</a></h4>
                                            <p>1 x $${item.getProductPrice()}</p>
                                        </div>
                                        <a class="aa-remove-product" href="#"><span class="fa fa-times"></span></a>
                                    </li>
                                    <#else>
                                    <h2>There are no items in your cart</h2>
                                    </#list>
                                </ul>
                                <#if shoppingCart?has_content>
                                <a class="aa-cartbox-checkout aa-primary-btn" href="/checkout">Checkout</a>
                                </#if>
                            </div>
                        </div>
                        <!-- / cart box -->
                        <!-- search box -->
                        <div class="aa-search-box">
                            <form action="">
                                <input type="text" name="" id="" placeholder="Search here ex. 'man' ">
                                <button type="submit"><span class="fa fa-search"></span></button>
                            </form>
                        </div>
                        <!-- / search box -->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- / header bottom  -->
</header>
<!-- / header section -->
<!-- menu -->
<section id="menu">
    <div class="container">
        <div class="menu-area">
            <!-- Navbar -->
            <div class="navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="navbar-collapse collapse">
                    <!-- Left nav -->
                    <ul class="nav navbar-nav">
                        <li><a href="/">Home</a></li>
                        <li><a href="#">Men <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/products">Casual</a></li>
                                <li><a href="/products">Sports</a></li>
                                <li><a href="/products">Formal</a></li>
                                <li><a href="/products">Standard</a></li>
                                <li><a href="/products">T-Shirts</a></li>
                                <li><a href="/products">Shirts</a></li>
                                <li><a href="/products">Jeans</a></li>
                                <li><a href="/products">Trousers</a></li>
                                <li><a href="#">And more.. <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="/products">Sleep Wear</a></li>
                                        <li><a href="/products">Sandals</a></li>
                                        <li><a href="/products">Loafers</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li><a href="#">Women <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/products">Kurta & Kurti</a></li>
                                <li><a href="/products">Trousers</a></li>
                                <li><a href="/products">Casual</a></li>
                                <li><a href="/products">Sports</a></li>
                                <li><a href="/products">Formal</a></li>
                                <li><a href="/products">Sarees</a></li>
                                <li><a href="/products">Shoes</a></li>
                                <li><a href="#">And more.. <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="/products">Sleep Wear</a></li>
                                        <li><a href="/products">Sandals</a></li>
                                        <li><a href="/products">Loafers</a></li>
                                        <li><a href="#">And more.. <span class="caret"></span></a>
                                            <ul class="dropdown-menu">
                                                <li><a href="/products">Rings</a></li>
                                                <li><a href="/products">Earrings</a></li>
                                                <li><a href="/products">Jewellery Sets</a></li>
                                                <li><a href="/products">Lockets</a></li>
                                                <li class="disabled"><a class="disabled" href="#">Disabled item</a></li>
                                                <li><a href="#">Jeans</a></li>
                                                <li><a href="#">Polo T-Shirts</a></li>
                                                <li><a href="#">SKirts</a></li>
                                                <li><a href="#">Jackets</a></li>
                                                <li><a href="#">Tops</a></li>
                                                <li><a href="#">Make Up</a></li>
                                                <li><a href="#">Hair Care</a></li>
                                                <li><a href="#">Perfumes</a></li>
                                                <li><a href="#">Skin Care</a></li>
                                                <li><a href="#">Hand Bags</a></li>
                                                <li><a href="#">Single Bags</a></li>
                                                <li><a href="#">Travel Bags</a></li>
                                                <li><a href="#">Wallets & Belts</a></li>
                                                <li><a href="#">Sunglases</a></li>
                                                <li><a href="#">Nail</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li><a href="#">Kids <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Casual</a></li>
                                <li><a href="#">Sports</a></li>
                                <li><a href="#">Formal</a></li>
                                <li><a href="#">Standard</a></li>
                                <li><a href="#">T-Shirts</a></li>
                                <li><a href="#">Shirts</a></li>
                                <li><a href="#">Jeans</a></li>
                                <li><a href="#">Trousers</a></li>
                                <li><a href="#">And more.. <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Sleep Wear</a></li>
                                        <li><a href="#">Sandals</a></li>
                                        <li><a href="#">Loafers</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li><a href="#">Sports</a></li>
                        <li><a href="#">Digital <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Camera</a></li>
                                <li><a href="#">Mobile</a></li>
                                <li><a href="#">Tablet</a></li>
                                <li><a href="#">Laptop</a></li>
                                <li><a href="#">Accesories</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Furniture</a></li>
                        <li><a href="blog-archive.html">Blog <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="blog-archive.html">Blog Style 1</a></li>
                                <li><a href="blog-archive-2.html">Blog Style 2</a></li>
                                <li><a href="blog-single.html">Blog Single</a></li>
                            </ul>
                        </li>
                        <li><a href="contact.html">Contact</a></li>
                        <li><a href="#">Pages <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="product.html">Shop Page</a></li>
                                <li><a href="product-detail.html">Shop Single</a></li>
                                <li><a href="404.html">404 Page</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>
    </div>
    </div>
</section>
<!-- / menu -->