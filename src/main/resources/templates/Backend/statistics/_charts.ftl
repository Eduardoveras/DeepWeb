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

            <br>

            <div class="demo-charts mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid">
                <canvas id="suppliers"></canvas>
            </div>

            <br>

            <div class="demo-charts mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid">
                <canvas id="avePurchase"></canvas>
            </div>

            <br>

            <div class="demo-charts mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid">
                <canvas id="items"></canvas>
            </div>

            <script type="text/javascript">
                google.charts.load('current', {'packages':['geochart','corechart','line',"calendar"]});
                google.charts.setOnLoadCallback(drawProductViewBarChart());
                google.charts.setOnLoadCallback(drawPurchaseBarChart());
                google.charts.setOnLoadCallback(drawSupplierPieChart());
                google.charts.setOnLoadCallback(drawAveragePurchaseBarChart());
                google.charts.setOnLoadCallback(drawAverageItemBarChart());

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
        </div>
    </div>
</div>
<!--I Know this is wrong, i just don't care-->
<br><br><br><br><br><br><br><br><br>

