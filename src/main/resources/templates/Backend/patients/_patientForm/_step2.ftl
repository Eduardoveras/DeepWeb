<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="bloodtype"><@spring.message "bType" /> <span
            class="required">*</span></label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <select id="bloodtype" name="bloodtype" class="form-control">
            <option>A+</option>
            <option>A-</option>
            <option>O+</option>
            <option>O-</option>
            <option>AB+</option>
            <option>AB-</option>
        </select>
    </div>
</div>

<div class="control-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="allergies"><@spring.message "allergies" /></label>
    <div id="tags_1_tagsinput" class="tagsinput" style="width: auto; min-height: 100px; height: 100px;">
                                <span class="tag"><span>social&nbsp;&nbsp;</span><a href="#" title="Removing tag">x</a>
                                </span>
        <span class="tag"><span>adverts&nbsp;&nbsp;</span><a href="#" title="Removing tag">x</a>
                                </span>
        <span class="tag"><span>sales&nbsp;&nbsp;</span><a href="#" title="Removing tag">x</a>
                                </span>

        <div id="allergies"><input id="allergies" name="allergies" value="" data-default="add a tag"
                                   style="color: rgb(102, 102, 102); width: 72px;">

        </div>
        <div class="tags_clear"></div>
    </div>
</div>


<div class="control-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="conditions"><@spring.message "conditions" /></label>
    <div id="tags_2_tagsinput" class="tagsinput" style="width: auto; min-height: 100px; height: 100px;">
                                <span class="tag"><span>social&nbsp;&nbsp;</span><a href="#" title="Removing tag">x</a>
                                </span>
        <span class="tag"><span>adverts&nbsp;&nbsp;</span><a href="#" title="Removing tag">x</a>
                                </span>
        <span class="tag"><span>sales&nbsp;&nbsp;</span><a href="#" title="Removing tag">x</a>
                                </span>

        <div id="conditions">
            <input id="conditions" name="conditions" value="" data-default="add a tag"
                   style="color: rgb(102, 102, 102); width: 72px;">

        </div>
        <div class="tags_clear"></div>
    </div>
</div>
