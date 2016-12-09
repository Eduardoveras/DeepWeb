<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <h2>
                Platano Statistics
            </h2>
        </div>
        <div class="x_content">
            <div class="demo-charts mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid">
                <canvas id="productV"></canvas>
            </div>

            <br>

            <div class="demo-charts mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid">
                <canvas id="purchaseS"></canvas>
            </div>

            <script type="text/javascript">
                google.charts.load('current', {'packages':['geochart','corechart','line',"calendar"]});
                google.charts.setOnLoadCallback(drawProductViewBarChart());
                //google.charts.setOnLoadCallback(drawSubFamilyChart);

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
            </script>
        </div>
    </div>
</div>
<!--I Know this is wrong, i just don't care-->
<br><br><br><br><br><br><br><br><br>

