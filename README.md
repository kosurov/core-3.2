# Работа с файлами. Сохранение игрового процесса

## Описание
В данной задаче выполнена сериализация Java класса, используя интерфейс `Serializable`, запись сериализованных файлов на жесткий диск, используя класс `FileOutputStream`, и упаковка их в архив с помощью `ZipOutputStream`.

Для выполнения задания проделываются следующие шаги:
1. Создается класс `GameProgress`, хранящий информацию об игровом процессе. 
2. Создаются три экземпляра класса `GameProgress`.
3. Сохраняются сериализованные объекты `GameProgress` в папку `savegames` из [предыдущей задачи](https://github.com/kosurov/core-3.1).
4. Созданные файлы сохранений из папки `savegames` запаковываются в архив `zip`.
5. Удаляются файлы сохранений, лежащие вне архива.
