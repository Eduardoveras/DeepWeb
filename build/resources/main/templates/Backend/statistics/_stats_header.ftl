<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Amazon Platano | </title>

    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- bootstrap-wysiwyg -->
    <link href="../vendors/google-code-prettify/bin/prettify.min.css" rel="stylesheet">
    <!-- Select2 -->
    <link href="../vendors/select2/dist/css/select2.min.css" rel="stylesheet">
    <!-- Switchery -->
    <link href="../vendors/switchery/dist/switchery.min.css" rel="stylesheet">
    <!-- starrr -->
    <link href="../vendors/starrr/dist/starrr.css" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="../vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="../vendors/animate.css/animate.min.css" rel="stylesheet">
    <!-- Datatables -->
    <link href="../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">
    <!-- FullCalendar -->
    <link href="../css/fullcalendar.min.css" rel="stylesheet">
    <link href="../css/fullcalendar.print.css" rel="stylesheet" media="print">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/css/bootstrap-datetimepicker.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/css/bootstrap-datetimepicker.min.css" />


    <!-- Custom Theme Style -->
    <link href="../build/css/custom.css" rel="stylesheet">

    <!-- Google Charts API -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
    <script src="/js/common.js"></script>

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.cyan-light_blue.min.css">
    <link rel="stylesheet" href="/css/common.css">
    <script defer src="https://code.getmdl.io/1.1.3/material.min.js"></script>

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">


        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawChart);


        function drawChart() {
            drawProductViewBarChart();
            drawPurchaseBarChart();
            drawSupplierPieChart();
            drawAveragePurchaseBarChart();
            drawAverageItemBarChart();
        }

        function drawProductViewBarChart() {
            var data = google.visualization.arrayToDataTable([
                ['Product', 'Views', { role: "style" }],
            <#list productsView as product>
                <#if product?is_last>
                        [${product}]
                <#else>
                        [${product}],
                </#if>
            </#list>
            ]);

            var options = {
                title: 'Views per Products',
                'min-width':300,
                'min-height':300,
                legend: 'none'
            };

            var chart = new google.visualization.BarChart(document.getElementById('productV'));
            chart.draw(data, options);
        }

        function drawPurchaseBarChart() {
            var data = google.visualization.arrayToDataTable([
                ['Product', 'Units', { role: "style" }],
            <#list purchaseStatistics as purchase>
                <#if purchase?is_last>
                        [${purchase}]
                <#else>
                        [${purchase}],
                </#if>
            </#list>
            ]);

            var options = {
                title: 'Units Purchased per Product',
                'min-width':300,
                'min-height':300,
                legend: 'none'
            };

            var chart = new google.visualization.BarChart(document.getElementById('purchaseS'));
            chart.draw(data, options);
        }

        function drawSupplierPieChart() {
            var data = google.visualization.arrayToDataTable([
                ['Supplier', 'Popularity'],
            <#list supplierStatistics as supplier>
                <#if supplier?is_last>
                        [${supplier}]
                <#else>
                        [${supplier}],
                </#if>
            </#list>
            ]);

            var options = {
                title: 'Supplier Popularity Among Buyers',
                'min-width':300,
                'min-height':300,
                legend: 'none'
            };

            var chart = new google.visualization.PieChart(document.getElementById('suppliers'));
            chart.draw(data, options);
        }

        function drawAveragePurchaseBarChart() {
            var data = google.visualization.arrayToDataTable([
                ['User', 'Dollars Spent', { role: "style" }],
            <#list averagePurchase as average>
                <#if average?is_last>
                        [${average}]
                <#else>
                        [${average}],
                </#if>
            </#list>
            ]);

            var options = {
                title: 'Average Purchase per User',
                'min-width':300,
                'min-height':300,
                legend: 'none'
            };

            var chart = new google.visualization.BarChart(document.getElementById('avePurchase'));
            chart.draw(data, options);
        }

        function drawAverageItemBarChart() {
            var data = google.visualization.arrayToDataTable([
                ['User', 'Items Bought', { role: "style" }],
            <#list averageItems as average>
                <#if average?is_last>
                        [${average}]
                <#else>
                        [${average}],
                </#if>
            </#list>
            ]);

            var options = {
                title: 'Average Items Purchased per User',
                'min-width':300,
                'min-height':300,
                legend: 'none'
            };

            var chart = new google.visualization.BarChart(document.getElementById('items'));
            chart.draw(data, options);
        }

    </script>

</head>