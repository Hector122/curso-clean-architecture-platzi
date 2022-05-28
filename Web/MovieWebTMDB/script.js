//URL: /discover/movie?sort_by=popularity.desc
//https://api.themoviedb.org/3/movie/550?api_key={{api_key_tmdb}}
//base url
const API_KEY = 'api_key=c9040ca82260ace0ea4a99bbcb665308'
const BASE_URL = 'https://api.themoviedb.org/3'
const API_URL = BASE_URL + '/discover/movie?sort_by=popularity.desc&' + API_KEY
const IMG_URL = 'https://image.tmdb.org/t/p/w500/'
const searchURL = BASE_URL + '/search/movie?' + API_KEY
const genresUrl = BASE_URL + '/genre/movie/list' + API_KEY

const main = document.getElementById('main')
const form = document.getElementById('form')
const search = document.getElementById('search')
const tags = document.getElementById('tags')

const next = document.getElementById('next')
const curent = document.getElementById('current')
const prev = document.getElementById('prev')

var selectGenere = []

//TODO: store this
// https://api.themoviedb.org/3/genre/movie/list?api_key=c9040ca82260ace0ea4a99bbcb665308
const genres = [
    {
        id: 28,
        name: 'Action',
    },
    {
        id: 12,
        name: 'Adventure',
    },
    {
        id: 16,
        name: 'Animation',
    },
    {
        id: 35,
        name: 'Comedy',
    },
    {
        id: 80,
        name: 'Crime',
    },
    {
        id: 99,
        name: 'Documentary',
    },
    {
        id: 18,
        name: 'Drama',
    },
    {
        id: 10751,
        name: 'Family',
    },
    {
        id: 14,
        name: 'Fantasy',
    },
    {
        id: 36,
        name: 'History',
    },
    {
        id: 27,
        name: 'Horror',
    },
    {
        id: 10402,
        name: 'Music',
    },
    {
        id: 9648,
        name: 'Mystery',
    },
    {
        id: 10749,
        name: 'Romance',
    },
    {
        id: 878,
        name: 'Science Fiction',
    },
    {
        id: 10770,
        name: 'TV Movie',
    },
    {
        id: 53,
        name: 'Thriller',
    },
    {
        id: 10752,
        name: 'War',
    },
    {
        id: 37,
        name: 'Western',
    },
]

setGenres()

//TODO: conver to a menu.
function setGenres() {
    tags.innerHTML = ''

    genres.forEach((genre) => {
        const element = document.createElement('div')
        element.classList.add('tag')
        element.id = genre.id
        element.innerText = genre.name
        element.addEventListener('click', () => {
            if (selectGenere.includes(element.id)) {
                selectGenere.forEach((id, position) => {
                    selectGenere.splice(position, 1)
                })
            } else {
                selectGenere.push(element.id)
            }

            console.log(selectGenere)

            getMovies(
                API_URL + '&with_genres=' + encodeURI(selectGenere.join(','))
            )

            highlithedSelection()
        })
        tags.append(element)
    })
}

function highlithedSelection() {
    const tags = document.querySelectorAll('.tag')
    tags.forEach((tag) => {
        tag.classList.remove('highlight')
    })

    clearButton()

    if (selectGenere.length != 0) {
        selectGenere.forEach((id) => {
            const highlithedTag = document.getElementById(id)
            highlithedTag.classList.add('highlight')
        })
    }
}

getMovies(API_URL)

function getMovies(url) {
    fetch(url)
        .then((res) => res.json())
        .then((data) => {
            console.log(data)

            if (data.results.length !== 0) {
                showMoviesResult(data.results)
            } else {
                main.innerHTML = `<h1 class="no-results">No Results Found</h1>`
            }
        })
}

function clearButton() {
    let clearBtn = document.getElementById('clear')

    if (clearBtn) {
        clearBtn.classList.add('highlight')
    } else {
        let clear = document.createElement('div')
        clear.classList.add('tag', 'highlight')
        clear.innerText = 'Clear X'
        clear.id = 'clear'
        clear.addEventListener('click', () => {
            selectGenere = []
            setGenres()
            getMovies(API_URL)
        })
        tags.append(clear)
    }
}

function showMoviesResult(data) {
    main.innerHTML = ''

    data.forEach((element) => {
        const { title, poster_path, vote_average, overview } = element

        const movie = document.createElement('div')
        movie.classList.add('movie')
        movie.innerHTML = `<img
        alt="${title}"
        src="${
            poster_path
                ? IMG_URL + poster_path
                : 'https://via.placeholder.com/1080x1580'
        }"
    />

    <div class="movie-detail">
        <h3>${title}</h3>
        <span class="${getColor(vote_average)}">${vote_average}</span>
    </div>

    <div class="overview">
        <h3>Overview</h3>
        ${overview}
    </div>`

        main.appendChild(movie)
    })
}

function getColor(value) {
    if (value > 8) {
        return 'green'
    } else if (value >= 5) {
        return 'orange'
    } else {
        return 'red'
    }
}

form.addEventListener('submit', (element) => {
    element.preventDefault()

    const searchTerm = search.value
    selectGenere = []
    setGenres()

    if (search) {
        getMovies(searchURL + '&query=' + searchTerm)
    }
})
