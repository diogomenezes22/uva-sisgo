$(document).ready(function() {	
	
	
   var $calendar = $('#calendar');
   
   $calendar.weekCalendar({
      timeslotsPerHour : 4,
      allowCalEventOverlap : true,
      overlapEventsSeparate: true,
      businessHours :{start: 8, end: 18, limitDisplay: true },
      height : function($calendar) {
         return $(window).height() - $("h1").outerHeight() - 1;
      },
      eventRender : function(calEvent, $event) {
         if (calEvent.end.getTime() < new Date().getTime()) {
            $event.css("backgroundColor", "#aaa");
            $event.find(".wc-time").css({
               "backgroundColor" : "#999",
               "border" : "1px solid #888"
            });
         }
      },
      draggable : function(calEvent, $event) {
         return calEvent.readOnly != true;
      },
      resizable : function(calEvent, $event) {
         return calEvent.readOnly != true;
      },
      eventNew : function(calEvent, $event) {
         var $dialogContent = $("#formConsulta");
         resetForm($dialogContent);
         var startField = $dialogContent.find("select[name='start']").val(calEvent.start);
         var endField = $dialogContent.find("select[name='end']").val(calEvent.end);
         var patientField = $dialogContent.find("input[name='patient']");
         var patientIdField = $dialogContent.find("input[name='patientId']");
         var dentistField = $dialogContent.find("input[name='dentist']");
         var dentistIdField = $dialogContent.find("input[name='dentistId']");
         var obsField = $dialogContent.find("textarea[name='obs']");
         clearScheduledBy($dialogContent);

         $dialogContent.dialog({
            modal: true,
            title: "Nova Consulta",
            close: function() {
               $dialogContent.dialog("destroy");
               $dialogContent.hide();
               $('#calendar').weekCalendar("removeUnsavedEvents");
            },
            buttons: {
               Salvar : function() {
            	   
            	   if(patientField.val() == "" || patientIdField.val() == "" || dentistField.val() == "" || dentistIdField.val() == "") {
            		   alert("Preencha todo o formulario da consulta!");
            		   return;
            	   }
            	   
					$.ajax({
						async: false,
						url: "/sisgo/agenda/salvar",
						type: "post",
						data: {
							"consulta.dataInicial": formatDate(new Date(startField.val())),
							"consulta.dataFinal": formatDate(new Date(endField.val())),
							"consulta.paciente.id": patientIdField.val(),
							"consulta.dentista.id": dentistIdField.val(),
							"consulta.obs": obsField.val()
						},
						error: function(jqXHR, textStatus, errorThrown) {
							alert("Erro ao salvar consulta!");
						},
						success: function(consultationId) {
							if(consultationId != null) {
								calEvent.id = consultationId;
								calEvent.start = new Date(startField.val());
								calEvent.end = new Date(endField.val());
								calEvent.patient = patientField.val();
								calEvent.patientId = patientIdField.val();
								calEvent.dentist = dentistField.val();
								calEvent.dentistId = dentistIdField.val();
								calEvent.obs = obsField.val();
																
								$calendar.weekCalendar("updateEvent", calEvent);								
							}
							else {
								alert("Erro ao salvar consulta!");
							}
						},
						complete: function() {
							$calendar.weekCalendar("removeUnsavedEvents");
							$dialogContent.dialog("close");
						}
					});					

               }
            }
         }).show();

         $dialogContent.find(".date_holder").text($calendar.weekCalendar("formatDate", calEvent.start));
         setupStartAndEndTimeFields(startField, endField, calEvent, $calendar.weekCalendar("getTimeslotTimes", calEvent.start));

      },
      eventDrop : function(calEvent, $event) {
    	  updateConsultation(calEvent)
      },
      eventResize : function(calEvent, $event) {
    	  updateConsultation(calEvent)
      },
      eventClick : function(calEvent, $event) {

         if (calEvent.readOnly) {
            return;
         }

         var consultation = loadConsultation(calEvent.id)
         
         var $dialogContent = $("#formConsulta");
         resetForm($dialogContent);
         var startField = $dialogContent.find("select[name='start']").val(calEvent.start);
         var endField = $dialogContent.find("select[name='end']").val(calEvent.end);
         var patientField = $dialogContent.find("input[name='patient']").val(calEvent.patient);
         var patientIdField = $dialogContent.find("input[name='patientId']").val(calEvent.patientId);
         var dentistField = $dialogContent.find("input[name='dentist']").val(calEvent.dentist);
         var dentistIdField = $dialogContent.find("input[name='dentistId']").val(calEvent.dentistId);
         var obsField = $dialogContent.find("textarea[name='obs']");
         obsField.val(calEvent.obs);
         showScheduledBy($dialogContent, consultation);

         $dialogContent.dialog({
            modal: true,
            title: "Consulta",
            close: function() {
               $dialogContent.dialog("destroy");
               $dialogContent.hide();
               $('#calendar').weekCalendar("removeUnsavedEvents");
            },
            buttons: {
               Salvar : function() {

					$.ajax({
						async: false,
						url: "/sisgo/agenda/atualizar",
						type: "post",
						data: {
							"consulta.id": calEvent.id,
							"consulta.dataInicial": formatDate(new Date(startField.val())),
							"consulta.dataFinal": formatDate(new Date(endField.val())),
							"consulta.paciente.id": patientIdField.val(),
							"consulta.dentista.id": dentistIdField.val(),
							"consulta.obs": obsField.val()
						},						
						error: function(jqXHR, textStatus, errorThrown) {
							alert("Erro ao atualizar consulta!");
						},
						success: function(updated) {
							if(updated == "true") {
								calEvent.start = new Date(startField.val());
								calEvent.end = new Date(endField.val());
								calEvent.patient = patientField.val();
								calEvent.patientId = patientIdField.val();
								calEvent.dentist = dentistField.val();
								calEvent.dentistId = dentistIdField.val();
								calEvent.obs = obsField.val();
																
								$calendar.weekCalendar("updateEvent", calEvent);								
							}
							else {
								alert("Erro ao atualizar consulta!");
							}
						},
						complete: function() {
							$calendar.weekCalendar("removeUnsavedEvents");
							$dialogContent.dialog("close");
						}
					});
               },
               Excluir : function() {
            	   
            	   if(confirm("Deseja excluir esta consulta?")) {
						$.ajax({
							async: false,
							url: "/sisgo/agenda/excluir/" + calEvent.id,
							type: "post",
							error: function(jqXHR, textStatus, errorThrown) {
								alert("Erro ao excluir consulta!");
							},
							success: function(deleted) {
								if(deleted == "true") {
									$calendar.weekCalendar("removeEvent", calEvent.id);								
								}
								else {
									alert("Nao e possivel excluir esta consulta!");
								}
							},
							complete: function() {
								$dialogContent.dialog("close");
							}
						});            	   
            	   }

               },
               Procedimentos: function() {
            	   location.href="/sisgo/procedimento-consulta/" + calEvent.id + "/listar";
               }
            }
         }).show();

         var startField = $dialogContent.find("select[name='start']").val(calEvent.start);
         var endField = $dialogContent.find("select[name='end']").val(calEvent.end);
         $dialogContent.find(".date_holder").text($calendar.weekCalendar("formatDate", calEvent.start));
         setupStartAndEndTimeFields(startField, endField, calEvent, $calendar.weekCalendar("getTimeslotTimes", calEvent.start));
         $(window).resize().resize(); //fixes a bug in modal overlay size ??

      },
      data : function(start, end, callback) {
         callback(getEventData());
      }
                  
   });

   function resetForm($dialogContent) {
      $dialogContent.find("input").val("");
      $dialogContent.find("textarea").val("");
   }

   function getEventData() {
	   
	   var consultas;
	   
		$.ajax({
			async: false,
			url: "/sisgo/agenda/carregar-consultas",
			type: "post",
			dataType: "json",
			error: function(jqXHR, textStatus, errorThrown) {
				alert("Erro ao buscar consultas");
			},
			success: function(consultasJson) {
				consultas = consultasJson;
			}
		});
		
		return {events : consultas};

   }


   /*
    * Sets up the start and end time fields in the calendar event
    * form for editing based on the calendar event being edited
    */
   function setupStartAndEndTimeFields($startTimeField, $endTimeField, calEvent, timeslotTimes) {

      for (var i = 0; i < timeslotTimes.length; i++) {
         var startTime = timeslotTimes[i].start;
         var endTime = timeslotTimes[i].end;
         var startSelected = "";
         if (dateEquals(startTime, calEvent.start)) {
            startSelected = "selected=\"selected\"";
         }
         var endSelected = "";
         if (dateEquals(endTime, calEvent.end)) {
            endSelected = "selected=\"selected\"";
         }
         $startTimeField.append("<option value=\"" + startTime + "\" " + startSelected + ">" + timeslotTimes[i].startFormatted + "</option>");
         $endTimeField.append("<option value=\"" + endTime + "\" " + endSelected + ">" + timeslotTimes[i].endFormatted + "</option>");

      }
      $endTimeOptions = $endTimeField.find("option");
      $startTimeField.trigger("change");
   }

   var $endTimeField = $("select[name='end']");
   var $endTimeOptions = $endTimeField.find("option");

   //reduces the end time options to be only after the start time options.
   $("select[name='start']").change(function() {
      var startTime = $(this).find(":selected").val();
      var currentEndTime = $endTimeField.find("option:selected").val();
      $endTimeField.html(
            $endTimeOptions.filter(function() {
               return startTime < $(this).val();
            })
            );

      var endTimeSelected = false;
      $endTimeField.find("option").each(function() {
         if ($(this).val() === currentEndTime) {
            $(this).attr("selected", "selected");
            endTimeSelected = true;
            return false;
         }
      });

      if (!endTimeSelected) {
         //automatically select an end date 2 slots away.
         $endTimeField.find("option:eq(1)").attr("selected", "selected");
      }

   });
   
	$("<div id=\"mouseOverMessage\" class=\"ui-corner-all\"></div>").prependTo($("body"));   
   
});

function updateConsultation(calEvent) {
	
	$.ajax({
		async: false,
		url: "/sisgo/agenda/atualizar",
		type: "post",
		data: {
			"consulta.id": calEvent.id,
			"consulta.dataInicial": formatDate(calEvent.start),
			"consulta.dataFinal": formatDate(calEvent.end),
			"consulta.paciente.id": calEvent.patientId,
			"consulta.dentista.id": calEvent.dentistId,
			"consulta.obs": calEvent.obs
		},						
		error: function(jqXHR, textStatus, errorThrown) {
			alert("Erro ao atualizar consulta!");
		},
		success: function(updated) {
			if(updated == "false") {			
				alert("Erro ao atualizar consulta!");
			}
		},
		complete: function() {
			$calendar.weekCalendar("removeUnsavedEvents");
		}
	});	
}

function loadConsultation(consultationId) {

	var consultation;
	
	$.ajax({
		async: false,
		url: "/sisgo/agenda/carregar-consulta/" + consultationId,
		type: "get",
		dataType: "json",
		error: function(jqXHR, textStatus, errorThrown) {
			alert("Erro ao carregar consulta!");
		},
		success: function(consultationJson) {
			consultation = consultationJson;
		}
	});	
	
	return consultation;
}

function showScheduledBy($dialogContent, consultation) {
	$dialogContent.find("#scheduledBy").html(consultation.usuario.nome);
	$dialogContent.find(".scheduledByItemList").fadeIn();
}

function clearScheduledBy($dialogContent) {
	$dialogContent.find("#scheduledBy").html("");
	$dialogContent.find(".scheduledByItemList").hide();
}

function formatDate(date) {
	return (date.getDate() < 10 ? '0' : '') + date.getDate() + "/" + (date.getMonth() < 9 ? '0' : '') + (date.getMonth() + 1) + "/" + date.getFullYear() + " " + (date.getHours() < 10 ? '0' : '') + date.getHours() + ":" + (date.getMinutes() < 10 ? '0' : '') + date.getMinutes();
}

function dateEquals(date1, date2) {
	var d1 = new Date(date1.getFullYear(), date1.getMonth(), date1.getDate(), date1.getHours(), date1.getMinutes(), 0, 0);
	var d2 = new Date(date2.getFullYear(), date2.getMonth(), date2.getDate(), date2.getHours(), date2.getMinutes(), 0, 0);
	return d1.getTime() == d2.getTime(); 
}
