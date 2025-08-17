Feature: the version can be retrieved

  Scenario: client makes call to GET
    When the client calls '/api/books'
    Then the client receives status code of 200

  Scenario: client makes call to POST
    When the client calls '/api/books' with body
      | title                    | author                    | isbn           | publishedDate | publisher      | genre                             | language | pageCount | format    | rating | summary                                | availableCopies | tags                                 |
      | The Pragmatic Programmer | Andrew Hunt, David Thomas | 978-0201616224 | 1999-10-30    | Addison-Wesley | Programming, Software Engineering | English  | 352       | Paperback | 4.5    | Covers principles for effective coding | 12              | clean code, software, best practices |

    Then the client receives status code of 200
