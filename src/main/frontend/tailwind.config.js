/** @type {import('tailwindcss').Config} */
module.exports = {
    content: ["../resources/templates/**/*.{html,js}"],
    theme: {
        extend: {},
    },
    plugins: [
        require('@tailwindcss/aspect-ratio'),
        require('tailwindcss'),
        require('autoprefixer'),
        require('@tailwindcss/forms'),
    ],
}