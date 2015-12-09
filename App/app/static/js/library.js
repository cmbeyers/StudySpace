<script type="text/javascript">
$(document).ready(function () {
                  document.getElementById("{{currentDay}}").classList.add("active");
                  });

/* var d1 = [[2, 12],
 [4, 15],
 [6, 30],
 [8, 37],
 [10, 53]
 ];*/


{% for day in dayAverageInfo %}
var day{{loop.index}} = {{ day|tojson|safe }};
var data{{loop.index}} = [
                          {label: "Occupancy in %",  data: day{{loop.index}}, points: { symbol: "circle", fillColor: "white" }, color: 'white'}
                          ];


{% endfor %}




$('#carousel').bind('slid.bs.carousel', function(e){
                    // $(document).ready(function(){
                    var wd="data"
                    
                    wd = wd.concat($(".item.active").attr("value"));
                    console.log(wd);
                    //alert('wd: '+wd);
                    var graphName = "#graph"
                    graphName = graphName.concat($(".item.active").attr("value"));
                    console.log(graphName)
                    
                    $.plot($("#graph2"), wd, {
                           xaxis: {
                           min: 0,
                           max: 23,
                           tickSize: 2,
                           tickLength: 0,
                           axisLabel: 'Time',
                           axisLabelUseCanvas: true,
                           axisLabelFontSizePixels: 12,
                           axisLabelFontFamily: 'Verdana, Arial, Helvetica, Tahoma, sans-serif',
                           axisLabelPadding: 5
                           },
                           yaxis: {
                           min: 0,
                           max: 100,
                           axisLabel: 'Percentage Full',
                           axisLabelUseCanvas: true,
                           axisLabelFontSizePixels: 12,
                           axisLabelFontFamily: 'Verdana, Arial, Helvetica, Tahoma, sans-serif',
                           axisLabelPadding: 5
                           },
                           series: {
                           lines: { show: true },
                           points: {
                           radius: 3,
                           show: true,
                           fill: true
                           },
                           },
                           grid: {
                           hoverable: true,
                           borderWidth: 1
                           }
                           
                           });
                    
                    
                    $(graphName).bind("plothover", function (event, pos, item) {
                                      $("#tooltip").remove();
                                      if (item) {
                                      var tooltip = item.series.data[item.dataIndex][2];
                                      
                                      $('<div id="tooltip">' + tooltip + '</div>')
                                      .css({
                                           position: 'absolute',
                                           display: 'none',
                                           top: item.pageY + 5,
                                           left: item.pageX + 5,
                                           border: '1px solid #fdd',
                                           padding: '2px',
                                           'background-color': '#fee',
                                           opacity: 0.80 })
                                      .appendTo("body").fadeIn(200);
                                      
                                      
                                      showTooltip(item.pageX, item.pageY, tooltip);
                                      }
                                      });
                    
                    
                    });
</script>


