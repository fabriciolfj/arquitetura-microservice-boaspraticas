# language: pt
Funcionalidade: Uso product

  Esquema do Cenário: Uso de um produto
    Dado um produto
      | code | describe  | dailyWithdrawal | limitDailyWithDrawal | rate | status |
      | 0012 | product01 | 5               | 100                  | 0    | 1      |
    Dado um saque <valor> para cliente '<customer>'
    Quando realizar uso do produto
    Entao deve contabilizar o uso do saque e saldo



    Exemplos:
      | valor | customer |
      | 50.00 | fulano   |
