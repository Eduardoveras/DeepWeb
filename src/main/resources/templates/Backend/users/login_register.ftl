<#include "/Backend/layouts/header.ftl">


<body class="login">
<#--include  "/layouts/_loader.ftl"-->
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">
        <div class="form-group animate form login_form item">
            <section class="login_content">
                <form METHOD="POST" enctype="multipart/form-data" action="/userLogin">
                    <h1><@spring.message "logIn" /></h1>
                    <div>
                        <input type="email" class="form-control" name="email" id="email" placeholder="<@spring.message "email" />" required="" />
                        <input type="hidden" name="origin" value="/admin">
                    </div>
                    <div>
                        <input type="password" class="form-control" name="password" id="password" placeholder="<@spring.message "password" />" required="" />
                    </div>
                    <div>
                        <input id="send" type="submit" value="<@spring.message "start" />" class="btn btn-default submit">
                        <a class="reset_pass" href="#"><@spring.message "lost" /></a>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link"><@spring.message "newTo" />
                            <a href="#signup" class="to_register"><@spring.message "createAccount" /></a>
                        </p>

                        <div class="clearfix"></div>
                        <br />

                        <div>
                            <h1><i class="fa fa-plus-circle"></i> Amazon Platano!</h1>
                            <p>©2016 All Rights Reserved. <br>Amazon Platano Privacy and Terms</p>
                        </div>
                    </div>
                </form>
            </section>
        </div>

        <div id="register" class="animate form registration_form">
            <section class="login_content">
                <form action="/newUser" method="post" enctype="multipart/form-data" >
                    <h1><@spring.message "createAccount" />t</h1>
                    <div>
                        <input type="text" name="username" class="form-control" placeholder="<@spring.message "username" />" required="" />
                    </div>
                    <div>
                        <input type="email" name="email" class="form-control" placeholder="<@spring.message "email" />" required="" />
                    </div>
                    <div>
                        <input type="password" name="password" class="form-control" placeholder="<@spring.message "password" />" required="" />
                    </div>
                    <div>
                        <input type="hidden" name="staff" value="JASC-STAFF-ADMIN" class="form-control" placeholder="<@spring.message "email" />" required="" />
                        <input type="submit" value="Register" class="btn btn-default submit" ></input>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">Already a member ?
                            <a href="#signin" class="to_register"> Log in </a>
                        </p>

                        <div class="clearfix"></div>
                        <br />

                        <div>
                            <h1><i class="fa fa-plus-circle"></i> Amazon Platano!</h1>
                            <p>©2016 All Rights Reserved. Amazon Platano. Privacy and Terms</p>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    </div>
</div>
<#include "/Backend/layouts/footer.ftl">
</body>
</html>
