def collatz(a, b):
    first_num = a
    second_num = b

    while first_num != 1 or second_num != 1:
        if not 0 == first_num % 2:
            first_num = first_num * 3 + 1
        else:
            first_num = first_num / 2
            if first_num == 1:
                return 'a'

        if not 0 == second_num % 2:
            second_num = second_num * 3 + 1
        else:
            second_num = second_num / 2
            if second_num == 1:
                return 'b'


a = int(input("Insert first number: "))
b = int(input("Insert second number: "))

print(collatz(a, b))
