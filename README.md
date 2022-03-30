# TMS Group Task

## Servlet, JSP, JSTL training.

--- 

## Table of contents

### 1. [Task description](https://github.com/IvanHayel/TMS_Group_2_Task#task-description)

### 2. [Distribution of responsibility](https://github.com/IvanHayel/TMS_Group_2_Task#distribution-of-responsibility)

### 3. [Tasks in progress](https://github.com/IvanHayel/TMS_Group_2_Task#tasks-in-progress)

### 4. [Completed tasks](https://github.com/IvanHayel/TMS_Group_2_Task#completed-tasks-)

--- 

### Task description

> Implement 4 servlets:
> 1) AuthorizationServlet (hide if already authorized)
> 2) RegistrationServlet (hide if already authorized)
> 3) CalculationServlet (only for authorized user)
> 4) CalculationHistoryServlet (only for authorized user)
>
> In the `history`, output all operations with a formatted date when this operation was made.

---

### Distribution of responsibility

|      **Dev**       | **Realize**                                                                           |
|:------------------:|:--------------------------------------------------------------------------------------|
| **Jana + Andrian** | `Entity`, `EntityStorage`                                                             |
|      **Jana**      | `User`, `UserService`, `RegistrationServlet`, `AuthorizationServlet`, `LogoutServlet` |
|    **Andrian**     | `Operation`, `OperationService`, `CalculationServlet`, `CalculationHistoryServlet`    |
|    **Dmitriy**     | `AuthorizationFilter`, `Home page` (html, css, bootstrap, jsp, jstl)                  |

---

### Tasks in progress
- [ ] `EntityStorage`
- [ ] `User`
- [ ] `Operation`
- [ ] `UserService`
- [ ] `OperationService`
- [ ] `RegistrationServlet`
- [ ] `AuthorizationServlet`
- [ ] `LogoutServlet`
- [ ] `CalculationServlet`
- [ ] `CalculationHistoryServlet`
- [ ] `AuthorizationFilter`
- [ ] `Frontend`

### Completed tasks ✅

- [X] `Entity`