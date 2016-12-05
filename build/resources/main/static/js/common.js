//for common JS files

$(window).load(function() {
    $(".loader").fadeOut("slow");
    newpatient.createRelatedSelector
    ( document.querySelector('#countries')           // from select element
        ,document.querySelector('#cities')      // to select element
        ,{                                               // values object
            RD: ['Santiago','La vega','Puerto Plata'],
            Venezuela: ['caracas','Blabla'],
            China: ['Hong kong','Namibia']
        }
    );
});

$(document).ready(function() {

    // page is now ready, initialize the calendar...
    var calHeight = 400;

    $('#calendar').fullCalendar({
        height:calHeight,
        contentHeight:calHeight,
        dayClick: function() {
            alert('a day has been clicked!');
        },
        editable: false, // Don't allow editing of events
        handleWindowResize: true,
        //weekends: false, // Hide weekends
        defaultView: 'agendaWeek', // Only show week view
        //header: false, // Hide buttons/titles
        //minTime: '07:30:00', // Start time for the calendar
        //maxTime: '22:00:00', // End time for the calendar
        //columnFormat: {
        //    week: 'ddd' // Only show day of the week names
       // },
        displayEventTime: true // Display event time
    });



});