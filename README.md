
# Pacman

Game Pacman merupakan game yang melegenda. Semua orang pasti pernah mendengar apa itu game pacman. Pada kesempatan kali ini, kelompok Codebreaker akan mencoba untuk membuat game pacman di java.
## API Reference

#### Get top 10 leaderboard score

```http
  GET /api/getLeaderboard
```

#### Post new submission

```http
  POST /api/submit
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`    | `string` | **Lenght must be 3**.  Name of the new score submission |
| `score`   | `int`    | The score that want to be submited |

#### Delete a submission

```http
  POST /api/delete/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`    | `Long` | **Reqired**. The id of submission that want to be removed |



## Authors
Kelompok Codebreaker

- ADITYA MARDI PRATAMA [@AdMFirst](https://github.com/AdMFirst)
- ANIKO RIZKI ROCHMAN [@nikoofficial](https://github.com/nikoofficial) 
- ANUGRAH SAPUTRA ARAS [@AnugrahSA](https://github.com/AnugrahSA)
- HABIB MUHAMMAD IRSYAD [@habibmirsyad](https://github.com/habibmirsyad)
- FARHAN HISYAM KARIM [@FarHK](https://github.com/FarHK)
- MUHAMMAD FIQRIL HAKIM [@LIRQIF](https://github.com/LIRQIF)


## Acknowledgements

 - [Pacman in Java, Programming Tutorial by gaspar coding](https://www.youtube.com/watch?v=ATz7bIqOjiA)
