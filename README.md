<!-- TABLE OF CONTENTS -->

# Dungeon Crawler - Roguelike game

<summary><h2 style="display: inline-block">Table of Contents</h2></summary>
<ol>
<li>
    <a href="#about-the-project">About The Project</a>
    <ul>
    <li><a href="#tech-used">Tech Used</a></li>
    </ul>
</li>
<li>
  <a href="#future-roadmap">Future Roadmap</a>
</li>
<li>
    <a href="#getting-started">Getting Started</a>
</li>


</ol>

<!-- ABOUT THE PROJECT -->

## About The Project

This is a simple roguelike game where a player can create a character and go dungeon delving for loot. The character can be moved using either arrow keys or WASD, pick up items from the floor to regenerate their life or increase their attack power/armor. Armor is used to reduce the magnitude of incoming hits - a heavily armored characted can withstand larger hits, but it gets damaged - and destroyed in the process.
The character can also pick up key to ascend to the next level.
The game also features various types of monsters, some of which can pass through walls and seek out the player actively when in range.

Although the game has full collision, you might want to try your luck with some of the walls...


Current features include:

- Start area, where you can name your character and explore easier rooms. <br/><br/>
  ![1](https://user-images.githubusercontent.com/79319253/167802832-3d215d98-64d0-4a2e-9edb-f70f4380a034.png)

  <br/>
  <br/>
  <br/>

- Spawrling maps to explore and various items to power you up. <br/><br/>
 ![2](https://user-images.githubusercontent.com/79319253/167802867-17d6a6b4-481b-4304-9596-700af01cd63e.png)

  <br/><br/><br/>

- Secret areas - try to find their access points !<br/><br/>
 ![3](https://user-images.githubusercontent.com/79319253/167802887-ad291cb1-1192-4bb1-8b0c-4bd0954304f5.png)

  <br/><br/><br/>

- Cheats ! <br/><br/>
![4](https://user-images.githubusercontent.com/79319253/167802905-9bff3e10-0496-431c-b065-b751b05e3b3a.png)

  <br/><br/><br/>

## Future roadmap


- Save/load game fixes
- Main menu screen with multiple hero archetype selector
- More maps with different themes
- Endgame boss fight 
- Add ranged/magic combat


### Tech Used

- Maven
- Java
- JavaFX
- Postgresql

<!-- GETTING STARTED -->

## Getting Started

To get a local copy up and running follow these simple steps.


1. Clone the repo
   ```sh
   git clone https://github.com/github_username/repo_name.git
   ```
2. Create your own application.properies file in the resources directory and write
   ```
    DATABASE = databaseName
    USERNAME = yourUsername
    PASSWORD = yourPassword
   ```

3. Run the sql script from the sample_data folder in your database

4. Make sure your device can run all the technologies in the build section
