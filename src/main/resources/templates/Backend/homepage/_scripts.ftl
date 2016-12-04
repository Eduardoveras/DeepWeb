<!-- bootstrap-daterangepicker -->
<script>
    $(document).ready($(function () {
        $('#datetimepicker2').datetimepicker();
    }));
</script>
<!-- /bootstrap-daterangepicker -->
<!-- jQuery Sparklines -->
<script>
    $(document).ready(function() {

        $(".sparkline_two").sparkline([2, 4, 3, 4, 5, 4, 5, 4, 3, 4, 5, 6, 7, 5, 4, 3, 5, 6], {
            type: 'line',
            width: '200',
            height: '40',
            lineColor: '#26B99A',
            fillColor: 'rgba(223, 223, 223, 0.57)',
            lineWidth: 2,
            spotColor: '#26B99A',
            minSpotColor: '#26B99A'
        });
    });
</script>


<!--FILL COUNTRIES-->
<script language="javascript">
    populateCountries("country", "state"); // first parameter is id of country drop-down and second parameter is id of state drop-down
</script>
<!--/FILL COUNTRIES-->


