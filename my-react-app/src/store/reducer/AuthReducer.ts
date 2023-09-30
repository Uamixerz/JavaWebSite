import { IAuthUser } from "../../enteties/Auth";


const initState: IAuthUser = {
    isAuth: false,
    user: undefined
};

export const AuthReducer = (state = initState, action: any): IAuthUser => {
    return state;
}