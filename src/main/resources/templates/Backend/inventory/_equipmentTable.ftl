<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#equipment"><@spring.message "newEquip" /></button>
<table id="datatable-responsive" class="table table-hover table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th><span style="text-transform: uppercase;"><@spring.message "idFrag1" /> ${user.clinic.clinicPrefix} <@spring.message "idFrag2" /></span></th>
        <th><span style="text-transform: uppercase;"><@spring.message "name" /></span></th>
        <th><span style="text-transform: uppercase;"><@spring.message "use" /></span></th>
        <th><span style="text-transform: uppercase;"><@spring.message "description" /></span></th>
        <th><span style="text-transform: uppercase;"><@spring.message "quantity" /></span></th>
    </tr>
    </thead>
    <tbody>
    <#list equipmentList as equipment>
    <tr>
        <td>${equipment.equipmentId}</td>
        <td>${equipment.equipmentName}</td>
        <td>${equipment.equipmentUse}</td>
        <td>${equipment.equipmentDescription}</td>
        <td>${equipment.equipmentInStock} <@spring.message "unit" /><#if equipment.equipmentInStock gt 1><@spring.message "plural" /></#if></td>
    </tr>
    <#else>
    <tr>
        <th scope="row"><span style="text-transform: uppercase;"><@spring.message "emptyEquipment" /></span></th>

    </tr>
    </#list>
    </tbody>
</table>