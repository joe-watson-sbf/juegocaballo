import * as actions from '../actions/caballoActions'

export const initialState = {
  caballos: [],
  distancia: 0
}

export default function caballoReducer(state = initialState, action) {
  switch (action.type) {
    case actions.MOVER:
      return { }
    default:
      return state
  }
}