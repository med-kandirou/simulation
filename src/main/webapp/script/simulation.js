//calcule prix
function calcule(){
    let taux = 5.5;
    let montant = document.getElementById('montant').value;
    let dure = document.getElementById('dure').value;
    let tauxMensuel = taux / (12 * 100);
    let mensualite = (montant * tauxMensuel) / (1 - Math.pow(1 + tauxMensuel, -dure));
    localStorage.setItem('taux', taux);
    localStorage.setItem('montant', montant);
    localStorage.setItem('dure', dure);
    localStorage.setItem('mensualite', mensualite);
    document.getElementById('mensualite').value=mensualite.toFixed(2);
    document.getElementById('confirmPrix').style.display='block';
}


//change divs
let simulate=document.getElementById('simulate');
let search=document.getElementById('search');
let info=document.getElementById('info');

function confirmprix(){
    simulate.style.display='none';
    search.style.display='block';
    info.style.display='none';
}

document.getElementById('simulate_tab').addEventListener("click",function (){
    simulate.style.display='block';
    search.style.display='none';
    info.style.display='none';
})

document.getElementById('search_tab').addEventListener("click",function (){
    simulate.style.display='none';
    search.style.display='block';
    info.style.display='none';
})

document.getElementById('info_tab').addEventListener("click",function (){
    simulate.style.display='none';
    search.style.display='none';
    info.style.display='block';
})

$(document).ready(function () {
    $("#searchButton").on("click", function () {
        simulate.style.display='none';
        search.style.display='none';
        info.style.display='block';

        var clienId = $("#find").val();
        $.ajax({
            url: "/client-search-simulation",
            type: "GET",
            data: { find : clienId },

            success: function (data) {
                $("#code").val(data.code);
                $("#fname").val(data.firstName);
                $("#lname").val(data.lastName);
                $("#birthday").val(data.birthday);
                $("#adresse").val(data.adresse);
                $("#phone").val(data.phone);
            },
            error: function (error) {
                window.location.href = "/client-create";
            }
        });
    });

    $("#confimDemande").on('click',function (){
        $.ajax({
            url: "/demande-create",
            type: "POST",
            data: {
                code : $("#code").val(),
                fname : $("#fname").val(),
                lname : $("#lname").val(),
                birthday : $("#birthday").val(),
                adresse : $("#adresse").val(),
                phone : $("#phone").val(),
                remarks : $("#remarks").val(),
                taux:localStorage.getItem('taux'),
                montant:localStorage.getItem('montant'),
                dure:localStorage.getItem('dure'),
                mensualite:localStorage.getItem('mensualite')
            },
            success: function (data) {
                if(data=='added'){
                    window.location.href = "/simulation-display";
                }
            },
            error: function (error) {
                //window.location.href = "/client-create";
                console.log(error);
            }
        });
    });
});
