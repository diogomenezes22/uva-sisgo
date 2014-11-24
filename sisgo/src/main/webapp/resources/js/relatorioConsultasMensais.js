$(function () {
	
	var dataRelatorio;
	
	$.ajax({
		async: false,
		url: "/sisgo/relatorio/consultas-mensais/gerar",
		type: "post",
		dataType: "json",
		error: function(jqXHR, textStatus, errorThrown) {
			alert("Erro ao gerar relatorio");
		},
		success: function(dataRelatorioJson) {
			dataRelatorio = alterarFormatoJson(dataRelatorioJson);
		}
	});	
	
    $('#graficoRelatorio').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'Consultas Mensais em 2014'
        },
        xAxis: {
            type: 'category',
            labels: {
                rotation: -45,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Consultas Agendadas'
            }
        },
        legend: {
            enabled: false
        },
        tooltip: {
            pointFormat: '<b>{point.y} consultas</b>'
        },
        series: [{
            name: 'Consultas',
            data: JSON.parse(dataRelatorio),
            dataLabels: {
                enabled: false,
                rotation: -90,
                color: '#FFFFFF',
                align: 'right',
                x: 4,
                y: 10,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif',
                    textShadow: '0 0 3px black'
                }
            }
        }]
    });
});
