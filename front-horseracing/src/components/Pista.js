import jinete from '../resources/jinete.gif';
import { connect } from 'react-redux';
import React, { useEffect } from 'react';

import { execLoading, execSuccess } from '../actions/juegoActions'

const Pista = ({dispatch, jugando, jinetes, loading, podio}) => {

    var socket = new WebSocket("ws://localhost:8080/progress");
    socket.onmessage = onMessage;

    function onMessage(event) {

        //Podemos obtener los id de los botones y deshabilitarlos
        //var btnSubmit = document.getElementById("btnSubmit");
        //btnSubmit.disabled = true;

        var data = JSON.parse(event.data); //Obtenemos el objeto json
        console.log(data);

        //loading lo volvemos true, con lo cual entra al useeffect de loading
        dispatch(execLoading())

        //Ejecutamos la logica para mover los caballos, recordar que se debe cambiar el switch de loading a false una vez
        //se finalice el movimiento y almacenamieto en el storage de las nuevas distancias
        data.jinetes.forEach((jin, i) => {
            document.getElementById('j' + (i+1)).style.display = "inline";
            document.getElementById('j' + (i+1)).style.marginLeft = 150 + i + "px"; //No es mas i sino mas la nueva distancia que me llega del back
        });

        //finalizar la carga para esperar el siguiente evento del back

        dispatch(execSuccess({}))
        
        //verificar porque quizas no es necesario
        //Al finalizar recordar reactivar los botones de juego
    }

    useEffect(() => {

       if(!jugando && podio != null){
        
        //Mostramos un alert con los ganadores, los cuales se almacenan en podio
       }

    }, [loading]);

    useEffect(() => {
        // Actualiza el título del documento usando la API del navegador

        
        console.log('cambio jugando')
        if(jugando){

            //

            /*
            var i = 150;
            while(i <= 152){
                let listJinetes = ['j1', 'j2', 'j3', 'j4', 'j5'];
                demo();
                listJinetes.forEach(jugador => {
                    document.getElementById(jugador).style.display = "inline";

                    document.getElementById(jugador).style.marginLeft = i + "px";
                    console.log('Se movio el jugador: ' + jugador);
                    //console.log(jugador);
                })
                i++;
                //console.log('Numero de i: ' + i);
            }
            */
        }

        
        
    }, [jugando]);

    return (
        <>
            <div className="bg-image p-3">
                { jinetes[0] && <span className="textdark-bgwhite span-fix"><b className="textwhite-bgdark ilb">Jugador1:</b> {jinetes[0].nombre} </span>}<br />
                { jinetes[1] && <span className="textwhite-bgdark span-fix"><b className="textdark-bgwhite ilb">Jugador2:</b> {jinetes[1].nombre} </span>}<br />
                { jinetes[2] && <span className="textdark-bgwhite span-fix"><b className="textwhite-bgdark ilb">Jugador3:</b> {jinetes[2].nombre} </span>}<br />
                { jinetes[3] && <span className="textwhite-bgdark span-fix"><b className="textdark-bgwhite ilb">Jugador4:</b> {jinetes[3].nombre} </span>}<br />
                { jinetes[4] && <span className="textdark-bgwhite span-fix"><b className="textwhite-bgdark ilb">Jugador5:</b> {jinetes[4].nombre} </span>}<br />
                {/*
                <span>{jinetes.jugador2 == null? '' : jinetes.jugador2.nombre}</span><br />
                <span>{jinetes.jugador3 == null? '' : jinetes.jugador3.nombre}</span><br />
                <span>{jinetes.jugador4 == null? '' : jinetes.jugador4.nombre}</span><br />
                <span>{jinetes.jugador5 == null? '' : jinetes.jugador5.nombre}</span><br />
                */}
                <img src={jinete} width="150" className="pi-jinete" id="j1"/><br />
                <img src={jinete} width="150" className="pi-jinete" id="j2"/><br />
                <img src={jinete} width="150" className="pi-jinete" id="j3"/><br />
                <img src={jinete} width="150" className="pi-jinete" id="j4"/><br />
                <img src={jinete} width="150" className="pi-jinete" id="j5"/><br />

                <button onClick={() => console.log(jinetes)}>Mostrar jinetes</button>
            </div>
        </>
    )
}

const mapStateToProps = state => {
    return {
      jugando: state.juego.jugando,
      jinetes: state.juego.jinetes,
      loading: state.juego.loading,
      podio: state.juego.podio,
    }
}

export default connect(mapStateToProps)(Pista)