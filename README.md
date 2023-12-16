## Описание программы - Магазин
Приложение запускается через основной файл Мain.java. Package - org.HomeworkShop.  
Реализованы следующие классы:  
### 1. Basket  
Класс корзины. Сохраняет Id пользователя - владельца данной корзины и список лежащих в ней товаров. Имеет методы  
- `getId`
- `toString`
### 2. BasketActions  
Класс имеет метод генерации Id корзины.
### 3. Good  
Класс товара. Имеет такие поля, как наименование товара и его кол-во.  
### 4. User
Класс пользователя. Имеет поля Id, список корзин и магазин, в котором этот пользователь имеет данные корзины.  
Реализованы методы:  
- `addBasket`
- `findBasketById`
- `buyBasket`
- `getId`
- `deleteBasket`
### 5. UserRepository
Хранит и обрабатывает информацию о всех пользователях одного магазина.
### 6. UserActions
Наследует класс UserRepository, выполняет следующие методы:  
- `generateId` - позволяет генерировать Id пользователя;
- `addUser` - вызывает соотвтествующий метод UserRepository;
- `findUserById` - вызывает соотвтествующий метод UserRepository;
### 7. Store
Класс магазина. Каждый объект класса имеет собственные UserRepository и UserActions. При создании принимает список товаров и преобразует его в HashMap.  
Выполняет следующие методы:  
- `getUserRepository`
- `getUserActions`
- `getAllGoodsOfStore`
- `deleteGood`
- `decreaseNumberOfGood`
- `printGoods`
