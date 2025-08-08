# 🎮 Tic Tac Toe Game Design (LLD)

---

## 📝 Problem Statement

Design and implement a **Tic Tac Toe** game that allows two players to play on an NxN board, alternating turns, and
determines the winner or a draw.

---

## ✅ Requirements

- **Two Players**: The game is played between two players.
- **Board**: Uses a customizable NxN board.
- **Turns**: Players take turns to place their symbol (X or O) on the board.
- **Win Condition**: Detects when a player has won (row, column, or diagonal).
- **Draw Condition**: Detects when the board is full and the game ends in a draw.
- **Input Validation**: Prevents moves to already occupied cells.
- **Extensibility**: Easily change board size or add features (like AI, leaderboard, etc).

---

## 🧩 Core Entities

### 1. `Game`

- Controls game flow, turn switching, and status updates.
- **Key Methods:**
    - `makeMove(int row, int col)`
    - `getGameStatus()`
    - `getCurrentPlayer()` ✅ *(custom method added)*

### 2. `Board`

- NxN matrix of cells, holds the state of the game board.
- **Key Methods:**
    - `placeMove(int row, int col, Symbol symbol)`
    - `isValid(int row, int col)`
    - `isFull()`
    - `getSymbol(int row, int col)`
    - `getSize()`

### 3. `Cell`

- Represents a single cell on the board.
- **Attributes:**
    - `Symbol symbol`

### 4. `Player`

- Represents a player with a name and symbol.
- **Key Methods:**
    - `getName()`
    - `getSymbol()`

### 5. `Symbol` (Enum)

- `X`, `O`, and optionally `EMPTY`

### 6. `GameStatus` (Enum)

- `IN_PROGRESS`, `DRAW`, `WIN`

---

## 🎯 Design Patterns Used

### ✅ Strategy Pattern

Used for implementing **win detection logic**. Multiple strategies can be applied for flexible and extensible win
checking.

**WinningStrategy Interface:**

- `checkIfWinner(Board board, Symbol symbol)`

**Concrete Strategies:**

- `RowWinningStrategy`
- `ColumnWinningStrategy`
- `DiagonalWinningStrategy`

Each strategy implements its own logic for win condition detection, allowing for easy extensibility and testing.

---

## 🧠 Bonus Extensibility Ideas

- Add a `MinimaxStrategy` for AI opponent.
- Add Observer Pattern for UI or logging.
- Save/Load game state.

---

## 👨‍💻 Example Functions Implemented

- `Game.makeMove(int row, int col)`
- `Game.getGameStatus()`
- `Game.getCurrentPlayer()`
- `Board.placeMove(...)`
- `Board.isValid(...)`
- `Board.checkWin(...)`
- `Board.isFull()`
- `Player.getName()`
- `Player.getSymbol()`

---

> Built with extensibility and design clarity in mind. This modular structure allows you to scale the game from CLI to
> GUI or online play easily.