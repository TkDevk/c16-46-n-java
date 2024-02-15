
import React from 'react'
import { useAuth } from '../hooks/useAuth'
import { AuthContext } from './AuthContext'

const AuthProvider = ({children}) => {
    const {
        handlerLogin,
        handlerLogout
    } = useAuth()
  return (
    <AuthContext.Provider
    value={{
        handlerLogin,
        handlerLogout
    }}>
      {children}
    </AuthContext.Provider>
  )
}

export default AuthProvider
