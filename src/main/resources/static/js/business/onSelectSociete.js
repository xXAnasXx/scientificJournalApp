$(document).ready(function () {

    onChangeSociete($("#selectSociete").find("option:first-child").val());
    $("#selectSociete").change(function () {
        var value = $("#selectSociete option:selected").val();
        onChangeSociete(value);
    });

    function onChangeSociete(selectedSociete) {
        fetchCompteBySelectedSociete(selectedSociete);
        fetchBanqueBySelectedSociete(selectedSociete);
    }

    function fetchCompteBySelectedSociete(selectedSociete){
        $.ajax({
            type: 'GET',
            url: '/refreshCompte?selectedSociete=' + selectedSociete,
            success: function (data) {
                $("#refreshedCompte").replaceWith(data);
            },
            error: function (error) {
                console.error(error);
            }
        });
    }

    function fetchBanqueBySelectedSociete(selectedSociete){
        $.ajax({
            type: 'GET',
            url: '/refreshBanque?selectedSociete=' + selectedSociete,
            success: function (data) {
                $("#refreshedBanque").replaceWith(data);
            },
            error: function (error) {
                console.error(error);
            }
        });
    }

});