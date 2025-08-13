# 🎲 Snake & Ladder Game Design (LLD)

---

## 📝 Problem Statement

Design and implement a **Snake & Ladder** game that allows multiple players to play on a configurable board with snakes and ladders, simulates dice rolls, enforces turn order, and determines the winner.

---

## ✅ Requirements

- **Multiple Players**: Supports two or more players.
- **Board**: Configurable size (typical 1..100).
- **Snakes and Ladders**: Special cells that move players down (snakes) or up (ladders).
- **Dice Roll**: Players roll dice to advance.
- **Turn Management**: Round-robin (FIFO) turn order.
- **Win Condition**: First player to reach the last cell wins.
- **Input Validation**: Prevent invalid moves (e.g., overshooting last cell).
- **Extensibility**: Easy to add multi-dice, power-ups, new board entities, UI hooks, etc.

---

## 🧩 Core Entities

### 1. `GameStatus` 
- Current state of game.
- **Values:**
  - `NOT_STARTED`
  - `IN_PROGRESS`
  - `FINISHED`
  - 
### 2. `Game` (SnakeAndLadderGame)
- Orchestrates game flow, turn switching, and win detection.
- **Key Methods:**
    - `play()` — main loop that processes turns.
    - `takeTurn(Player player)` — executes one player's turn.
    - `getWinner()` / `getGameStatus()`

### 3. `Board`
- Represents the board; stores snakes and ladders for O(1) lookup.
- Internally uses integer cell numbers (1..N) for game logic.
- **Key Methods:**
    - `getSize()`
    - `getSnakeAt(int position)` → returns `Snake` or `null`
    - `getLadderAt(int position)` → returns `Ladder` or `null`

### 4. `BoardEntity` (abstract)
- Base for special board items.
- **Attributes:**
    - `start` (int)
    - `end` (int)

### 5. `Snake` (extends `BoardEntity`)
- Moves player down: `start > end`.

### 6. `Ladder` (extends `BoardEntity`)
- Moves player up: `start < end`.

### 7. `BoardEntityFactory`
- Centralized creation & validation for snakes/ladders (Factory Pattern).
- **Key Methods:**
    - `createSnake(int start, int end)`
    - `createLadder(int start, int end)`

### 8. `Player`
- Represents a player with name and current position.
- **Key Methods:**
    - `getName()`, `getPosition()`, `setPosition(int pos)`

### 9. `DiceStrategy` (interface / abstraction)
- Strategy Pattern for dice behavior (single, multiple, loaded, deterministic).
- **Key Methods:**
    - `roll()` → returns int

### 10. `Concrete Dice Implementations`
- `SingleDice` — standard 1..6
- `DoubleDice` — sum of two dice
- `FixedSequenceDice` — deterministic for testing

---

## 🎯 Design Patterns Used (where & why)

### ✅ Factory Pattern — `BoardEntityFactory`
**Where:** Creating `Snake` and `Ladder` objects (used in setup).  
**Why:** Centralizes validation rules (e.g., snake's end < start), keeps setup clean, and makes it easy to add new entity types (e.g., `Portal`, `Trap`) later.

### ✅ Strategy Pattern — `DiceStrategy`
**Where:** Injected into `Game` to perform dice rolls.  
**Why:** Decouples dice logic from game logic. Swap dice behaviors (single/multi/loaded/fixed) without changing `Game`. Great for testing (deterministic dice) and features (power-up dice).

### ✅ Turn Management — `Queue<Player>`
**Where:** `Game` maintains a FIFO queue of players.  
**Why:** Simple round-robin semantics: `poll()` current player → `takeTurn()` → `offer()` back unless they win.

### ✅ SRP & OCP (Design Principles)
**Where:** Class responsibilities are separated — `Board` holds layout, `Game` controls flow, `DiceStrategy` handles rolling.  
**Why:** Easier to test, extend, and maintain.

---

## 🧾 Example Functions / Methods (conceptual list)

- `Game.play()` — run the game loop until a winner exists.
- `Game.takeTurn(Player player)` — roll, compute next position, apply entities, update position, check winner.
- `Board.getSnakeAt(int pos)` / `Board.getLadderAt(int pos)`
- `Board.toRowCol(int pos)` — optional UI helper (handles zig-zag board rendering).
- `BoardEntityFactory.createSnake(start, end)` / `createLadder(start, end)`
- `DiceStrategy.roll()` — pluggable roll implementation.
- `Player.getName()`, `Player.getPosition()`, `Player.setPosition(int)`

---

