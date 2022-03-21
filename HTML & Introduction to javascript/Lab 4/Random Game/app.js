document.addEventListener('DOMContentLoaded', () => {

  cardArray = [

    {
      name: 'photo1',
      img: 'images/photo1.png'
    },
    {
      name: 'photo1',
      img: 'images/photo1.png'
    },
    {
      name: 'photo2',
      img: 'images/photo2.png'
    },
    {
      name: 'photo2',
      img: 'images/photo2.png'
    },
    {
      name: 'photo3',
      img: 'images/photo3.png'
    },
    {
      name: 'photo3',
      img: 'images/photo3.png'
    },
    {
      name: 'photo4',
      img: 'images/photo4.png'
    },
    {
      name: 'photo4',
      img: 'images/photo4.png'
    },
    {
      name: 'photo5',
      img: 'images/photo5.png'
    },
    {
      name: 'photo5',
      img: 'images/photo5.png'
    }
    ,
    {
      name: 'photo6',
      img: 'images/photo6.png'
    },
    {
      name: 'photo6',
      img: 'images/photo6.png'
    }
  ]

  const grid = document.querySelector('.grid');
  const resultDisplay = document.querySelector('#result')

  var cardChosen = []
  var cardChosenId = []
  var cardsWon = []

  function createBoard() {
    cardArray.sort((a, b) => 0.5 - Math.random());
    for (let i = 0; i < cardArray.length; i++) {

      var card = document.createElement('img')
      card.setAttribute('src', 'images/blank2.png')
      card.setAttribute('data-id', i)

      card.addEventListener('click', flipCard)
      grid.appendChild(card)

    }

  }

  function checkForMatch() {

    var cards = document.querySelectorAll('img')
    const optionOneId = cardChosenId[0]
    const optiontwoId = cardChosenId[1]
    console.log(cards[optionOneId].getAttribute('src'))
    if (cardChosen[0] === cardChosen[1]) {

      setTimeout("", 500)
      cards[optionOneId].setAttribute('src', 'images/white.png')
      cards[optiontwoId].setAttribute('src', 'images/white.png')
      cardsWon.push(optionOneId)
      cardsWon.push(optiontwoId)

    } else {
      cards[optionOneId].setAttribute('src', 'images/blank2.png')
      cards[optiontwoId].setAttribute('src', 'images/blank2.png')
      setTimeout("", 500)
    }

    cardChosen = []
    cardChosenId = []
    resultDisplay.textContent = cardsWon.length

    if (cardsWon.length >= cardArray / 2) {
      resultDisplay.textContent = 'CONGRATULATION!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!'
    }

  }


  function flipCard() {

    console.log(cardsWon)
    console.log(this.getAttribute('data-id'))
    console.log(cardsWon.includes(this.getAttribute('data-id')))

    
    if (!cardsWon.includes(this.getAttribute('data-id'))) {
      var cardId = this.getAttribute('data-id')
      cardChosen.push(cardArray[cardId].name)
      cardChosenId.push(cardId)
      this.setAttribute('src', cardArray[cardId].img)
      if (cardChosen.length === 2) {
        setTimeout(checkForMatch, 500)
      }
    }
  }

  createBoard()

})

