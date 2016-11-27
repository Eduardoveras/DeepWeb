<div class="x_panel">
    <div class="x_title">
        <h2><@spring.message "productForm" /></h2>
        <div class="clearfix"></div>
    </div>
    <div class="x_content">
        <br>
        <form action="/newProduct" METHOD="POST" id="demo-form2" data-parsley-validate="" class="form-horizontal form-label-left" novalidate="">

            <div class="form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name"><@spring.message "name" /> <span class="required">*</span>
                </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <input type="text" id="name" name="name" required="required" class="form-control col-md-7 col-xs-12">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="supplier"><@spring.message "supplier" /> <span class="required">*</span>
                </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <input type="text" id="supplier" name="supplier" required="required" class="form-control col-md-7 col-xs-12">
                </div>
            </div>

            <div class="form-group">
                <label for="description" class="control-label col-md-3 col-sm-3 col-xs-12"><@spring.message "description" /> </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <input id="description" class="form-control col-md-7 col-xs-12" type="text" name="description">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="price"><@spring.message "price" /> <span class="required">*</span>
                </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <input type="text" id="price" name="price" required="required" class="form-control col-md-7 col-xs-12">
                </div>
            </div>

            <div class="form-group">
                <label for="quantity" class="control-label col-md-3 col-sm-3 col-xs-12"><@spring.message "quantity" /> <span class="required">*</span>
                </label>
                <div class="container">
                    <div class="row">
                        <div class="col-xs-3 col-xs-offset-3">
                            <div class="input-group number-spinner">
				<span class="input-group-btn">
					<button class="btn btn-default" type="button" data-dir="dwn"><span class="glyphicon glyphicon-minus"></span></button>
				</span>
                                <input type="text" name="quantity" class="form-control text-center" value="1">
                                <span class="input-group-btn">
					<button class="btn btn-default" type="button" data-dir="up"><span class="glyphicon glyphicon-plus"></span></button>
				</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="ln_solid"></div>
            <div class="form-group">
                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                    <button type="submit" class="btn btn-success"><@spring.message "submit" /></button>
                </div>
            </div>

        </form>
    </div>
</div>