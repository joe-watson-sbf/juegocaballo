import * as actions from '../actions/juegoActions'

export const initialState = {
  loading: false,
  jugando: false,
  jinetes: [],
  kmpista: {
    km10: true,
    km20: false,
    km50: false,
  },
  podio: null
}

export default function juegoReducer(state = initialState, action) {
  switch (action.type) {
    case actions.LOADING:
      return { ...state, loading: true }
    case actions.LOADED_SUCCESS:
      return { ...state, ...action.payload, loading: false }
    case actions.LOADED_FAILURE:
      return { ...state, loading: false }
    case actions.INICIAR:
      return { ...state, jugando: true }
    case actions.AGREGAR_JINETE:
      let newListJinetes = state.jinetes;
      newListJinetes.push(action.payload);

      return { ...state, jinetes: newListJinetes, loading: false }
    default:
      return state
  }
}