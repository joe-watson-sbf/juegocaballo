import { combineReducers } from 'redux'
import juegoReducer from './juegoReducer';
import caballoReducer from './caballoReducer';

const rootReducer = combineReducers({
    juego: juegoReducer,
    caballo: caballoReducer
})

export default rootReducer
