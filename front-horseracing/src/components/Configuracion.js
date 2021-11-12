import { addJinete, sendDataToStart, startGame } from '../actions/juegoActions'
import { connect } from 'react-redux';
import React, { useState } from 'react';

const Configuracion = ({dispatch, jugando, jinetes, loading, kmpista}) => {

    const [color, setColor] = useState('azul');
    const [km, setKm] = useState(kmpista);

    const onAdd = () => {
        let nombre = document.getElementById('jugador').value;
        document.getElementById('jugador').value = '';
        dispatch(addJinete({nombre, color}));
        //console.log(jinetes)
    }

    const onInit = () => {
        let kmSelected = 0;
        if(km.km10){
            kmSelected = 10;
        }else if(km.km20){
            kmSelected = 20;
        }else if(km.km50){
            kmSelected = 50;
        }

        dispatch(sendDataToStart({kilometros: kmSelected, jinetes }));
        //dispatch(startGame());
    }

    const onCheckChange = (wichkm) => {
        let copyKm = {
            km10: false,
            km20: false,
            km50: false,
        };
        switch(wichkm){
            case 'km10':
                copyKm.km10 = true;
                break;
            case 'km20':
                copyKm.km20 = true;
                break;
            case 'km50':
                copyKm.km50 = true;
                break;
        }
        //console.log(copyKm);
        setKm(copyKm);
    }

    return (
        <>
            <div className="bg-config p-3">
                <h2 align="center" className="text-white mb-3">Configuracion del juego</h2>
                <hr className="text-white"/>
                <div align="center" className="mb-3">
                    <span className="text-warning pr-1">Kilometros de la pista:</span>
                    <div className="form-check form-check-inline">
                        <input className="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1" onChange={() => onCheckChange('km10')} checked={km.km10}/>
                        <label className="form-check-label" htmlFor="inlineRadio1">10 Km</label>
                    </div>
                    <div className="form-check form-check-inline">
                        <input className="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2" onChange={() => onCheckChange('km20')} checked={km.km20}/>
                        <label className="form-check-label" htmlFor="inlineRadio2">20 Km</label>
                    </div>
                    <div className="form-check form-check-inline">
                        <input className="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3" onChange={() => onCheckChange('km50')} checked={km.km50}/>
                        <label className="form-check-label" htmlFor="inlineRadio3">50 Km</label>
                    </div>
                </div>

                <div align="center" className="mb-4">
                    <span className="text-warning pr-1">Nombre del jugador:</span>
                    <input type="text" id="jugador" className="mr-3"/> 

                    <span className="text-warning pr-1">Color:</span>
                    <button type="button" className="btn btn-primary mr-1" onClick={() => setColor('azul')}>🙂</button>
                    <button type="button" className="btn btn-success mr-1" onClick={() => setColor('verde')}>🙂</button>
                    <button type="button" className="btn btn-danger mr-1" onClick={() => setColor('rojo')}>🙂</button>
                    <button type="button" className="btn btn-dark mr-1" onClick={() => setColor('negro')}>🙂</button>
                    <button type="button" className="btn btn-warning mr-3" onClick={() => setColor('amarillo')}>🙂</button>

                    <button type="button" className="btn c-button mr-1" onClick={onAdd}>Agregar Jinete</button>
                </div>

                <div align="center">
                    <button type="button" className="btn c-button"  onClick={onInit}>Iniciar Carrera</button>
                </div>
            </div>
        </>
    )
}

const stateMapToPros = state => {
    return {
      jugando: state.juego.jugando,
      jinetes: state.juego.jinetes,
      loading: state.juego.loading,
      kmpista: state.juego.kmpista
    }
}

export default connect(stateMapToPros)(Configuracion)