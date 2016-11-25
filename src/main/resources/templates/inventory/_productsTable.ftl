<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#product"><@spring.message "newProduct" /></button>
<table id="datatable-responsive" class="table table-hover table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th><span style="text-transform: uppercase;"><@spring.message "idFrag1" /> ${user.clinic.clinicPrefix} <@spring.message "idFrag2" /></span></th>
        <th><span style="text-transform: uppercase;"><@spring.message "name" /></span></th>
        <th><span style="text-transform: uppercase;"><@spring.message "description" /></span></th>
        <th><span style="text-transform: uppercase;"><@spring.message "supplier" /></span></th>
        <th><span style="text-transform: uppercase;"><@spring.message "price" /></span></th>
        <th><span style="text-transform: uppercase;"><@spring.message "quantity" /></span></th>
        <th><span style="text-transform: uppercase;">Delete</span></th>
    </tr>
    </thead>
    <tbody>
    <#list productList as product>
    <tr>
        <td>${product.productId}</td>
        <td>${product.productName}</td>
        <td>${product.productDescription}</td>
        <td>${product.supplier}</td>
        <td>$${product.productPrice}</td>
        <td>${product.productInStock} <@spring.message "unit" /><#if product.productInStock gt 1><@spring.message "plural" /></#if></td>
        <td>
            <form method="post" action="/deleteProduct">
                <input type="hidden" name="id" value="${product.productId}">
                <input type="submit" class="btn btn-small btn-danger" onclick="return confirm('<@spring.message "confirmMessage" />');" value="DELETE">
            </form>
        </td>
    </tr>
    <#else>
    <tr>
        <th scope="row"><@spring.message "emptyProduct" /></th>
    </tr>
    </#list>
    </tbody>
</table>