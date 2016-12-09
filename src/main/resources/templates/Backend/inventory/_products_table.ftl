<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <h2>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#meeting"><i class="fa fa-plus"></i> Product</button>
            </h2>
            <div class="clearfix"></div>
        </div>
        <div class="x_content">
            <table id="datatable-responsive" class="table table-hover table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th><span style="text-transform: uppercase;"><@spring.message "idFrag1" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "name" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "description" /></span></th>
                    <th><span style="text-transform: uppercase;"><@spring.message "price" /></span></th>
                    <th><span style="text-transform: uppercase;">Stock</span></th>
                    <th><span style="text-transform: uppercase;">Supplier</span></th>
                    <th><span style="text-transform: uppercase;">Options</span></th>
                </tr>
                </thead>
                <tbody>
                <#list selection as product>
                <tr>
                    <td>${product.getProductId()}</td>
                    <td>${product.getProductName()}</td>
                    <td>${product.getProductDescription()}</td>
                    <td>${product.getProductPrice()}</td>
                    <td>${product.getProductInStock()}</td>
                    <td>${product.getSupplier()}</td>
                    <td>
                        <div class="dropdown">
                            <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Options
                                <span class="caret"></span></button>
                            <ul class="dropdown-menu">
                                <li><a href="#">RE-STOCK</a></li>
                                <li><a href="/admin/inventory/edit/${product.getProductId()}">EDIT</a></li>
                                <li><form action="/admin/delete_product" method="post" enctype="multipart/form-data">
                                    <input type="hidden" name="ID" id="ID" value="${product.getProductId()}">
                                    <input type="submit" value="DELETE" class="btn btn-danger">
                                </form></li>
                            </ul>
                        </div>
                    </td>
                </tr>
                <#else>
                <tr>
                    <th scope="row"><@spring.message "emptyPatient" /></th>

                </tr>
                </#list>
                </tbody>
            </table>

        </div>
    </div>
</div>
<!--I Know this is wrong, i just don't care-->
<br><br><br><br><br><br><br><br><br>

