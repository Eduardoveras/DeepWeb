<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#medications"><@spring.message "newMed" /></button>
<table id="datatable-responsive" class="table table-hover table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th><span style="text-transform: uppercase;"><@spring.message "idFrag1" /> ${user.clinic.clinicPrefix} <@spring.message "idFrag2" /></span></th>
        <th><span style="text-transform: uppercase;"><@spring.message "name" /></span></th>
        <th><span style="text-transform: uppercase;"><@spring.message "supplier" /></span></th>
        <th><span style="text-transform: uppercase;"><@spring.message "description" /></span></th>
        <th><span style="text-transform: uppercase;"><@spring.message "price" /></span></th>
        <th><span style="text-transform: uppercase;"><@spring.message "quantity" /></span></th>
    </tr>
    </thead>
    <tbody>
    <#list medicationList as medication>
    <tr>
        <td>${medication.medicationId}</td>
        <td>${medication.medicationName}</td>
        <td>${medication.supplier}</td>
        <td>${medication.medicationDescription}</td>
        <td>$${medication.medicationPrice}</td>
        <td>${medication.medicationInStock} <@spring.message "unit" /><#if medication.medicationInStock gt 1><@spring.message "plural" /></#if></td>
    </tr>
    <#else>
    <tr>
        <th scope="row"><@spring.message "emptyMedication" /></th>

    </tr>
    </#list>
    </tbody>
</table>