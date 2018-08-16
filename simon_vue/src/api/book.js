import fetch from './fetch'

export function showBooks () {
    return fetch({
        url: '/show_books',
        method: 'GET'
    })
}
