const URL_BASE = 'http://localhost:8080';

export const INICIAR = 'INICIAR'
export const AGREGAR_JINETE = 'AGREGAR_JINETE'

export const LOADING = 'LOADING'
export const LOADED_SUCCESS = 'LOADED_SUCCESS'
export const LOADED_FAILURE = 'LOADED_FAILURE'

export const loading = () => ({ type: LOADING })

export const success = payload => ({
    type: LOADED_SUCCESS,
    payload
});

export const failure = () => ({ type: LOADED_FAILURE })

export function addJinete(jinete) {
    return async dispatch => {
        dispatch(loading())
        dispatch({
            type: AGREGAR_JINETE,
            payload: jinete
        })
    }
}

export function sendDataToStart(payload){
    return async dispatch => {
        dispatch(loading())

        try {
            const response = await fetch(`${URL_BASE}/createGame`,
                {
                    method: 'POST',
                    mode: 'cors',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(payload)
                }
            )

            //la respuesta del servidor quizás sea solo el ID
            dispatch({type: INICIAR})
            dispatch(success({id: response})) //aqui almacenamos el id en el storage y cambiamos el loading a false


        } catch (error) {
            dispatch(failure())
        }
    }
}

export function startGame(){
    return async dispatch => {
        dispatch({ type: INICIAR })
    }

}

export function execLoading(){
    //ese async deberiamos quitarlo
    return async dispatch => {
        dispatch(loading());
    }

}

export function execSuccess(payload){
    //ese async deberiamos quitarlo
    return async dispatch => {
        dispatch(success(payload));
    }

}