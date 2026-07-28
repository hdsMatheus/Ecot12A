# Resident Evil 3 
Projeto acadêmico desenvolvido para a disciplina de Programação Orientada a Objetos (ECOT02 — UNIFEI), utilizando o universo de *Resident Evil 3* como cenário para aplicar conceitos de POO e padrões de projeto na prática.

O programa simula uma sequência de combate, exploração e uso de itens envolvendo a personagem Jill Valentine, enfrentando inimigos icônicos da franquia como Zumbis, Hunters e o Nemesis.

## Funcionalidades

- Sistema de combate por turnos entre sobrevivente e inimigos
- Inventário com armas, munição, itens de cura e itens-chave
- Locomoção entre localizações (`Location`) com inimigos e itens próprios
- HUD que reage em tempo real a eventos do jogo (combate, exploração, chefes)
- Gerenciador central de estado do jogo (dificuldade, jogador, localização atual)

## Padrões de projeto utilizados

| Padrão | Onde | Papel |
|---|---|---|
| **Singleton** | `GameManager` | Garante uma única instância responsável pelo estado global do jogo |
| **Observer** | `GameManager` (subject) → `HUD` (observer) | O HUD é notificado automaticamente a cada evento (`GameEvent`) disparado durante a partida |

## Estrutura de classes

**Personagens** — hierarquia a partir da classe abstrata `Character`:
- `Survivor` (Jill Valentine)
- `Enemy` → `Zombie`, `Hunter`, `Nemesis`

**Itens** — hierarquia a partir da classe abstrata `Item`:
- `Weapon`, `Ammo`, `HealingItem`, `KeyItem`
- Gerenciados pela classe `Inventory`

**Eventos** — hierarquia a partir de `GameEvent`, notificados via `GameObserver`:
- `CombatEvent`, `ExploreEvent`, `BossEvent`

**Ambiente**
- `Location` — localizações do jogo, cada uma com seus próprios inimigos e itens

## Tecnologias

- Java 17
- Maven (`exec-maven-plugin` para execução direta da classe `Main`)

## Como executar

Pré-requisitos: Java 17+ e Maven instalados.

```bash
mvn compile exec:java
```

A simulação roda diretamente pela classe `Main`, que monta o cenário inicial (Jill Valentine, armas, itens, inimigos e localizações) e executa uma sequência de eventos de exemplo: combate, cura, exploração e uso de item-chave.

## Estrutura do repositório
