Certainly! Below is a **comprehensive Angular Framework Cheat Sheet** designed to provide quick references to essential Angular concepts, commands, syntax, and best practices. Whether you're a beginner or an experienced developer, this cheat sheet will serve as a handy guide to streamline your Angular development process.

---

## 📁 **Table of Contents**

1. [Project Structure](#1-project-structure)
2. [Angular CLI Commands](#2-angular-cli-commands)
3. [Components](#3-components)
4. [Data Binding](#4-data-binding)
5. [Directives](#5-directives)
6. [Pipes](#6-pipes)
7. [Services & Dependency Injection](#7-services--dependency-injection)
8. [Routing](#8-routing)
9. [Forms](#9-forms)
10. [HTTP Client](#10-http-client)
11. [Lifecycle Hooks](#11-lifecycle-hooks)
12. [Modules](#12-modules)
13. [Commonly Used Built-in Directives](#13-commonly-used-built-in-directives)
14. [Commonly Used Built-in Pipes](#14-commonly-used-built-in-pipes)
15. [Best Practices](#15-best-practices)
16. [Useful Resources](#16-useful-resources)

---

## 1. 📂 **Project Structure**

An Angular project typically follows a standard structure:

```
my-angular-app/
├── e2e/                        # End-to-end tests
├── node_modules/               # Installed npm packages
├── src/
│   ├── app/
│   │   ├── components/         # Reusable components
│   │   ├── services/           # Services for business logic
│   │   ├── app-routing.module.ts
│   │   ├── app.component.ts
│   │   ├── app.module.ts
│   │   └── ... 
│   ├── assets/                 # Static assets (images, styles)
│   ├── environments/           # Environment configurations
│   ├── index.html              # Main HTML file
│   ├── main.ts                 # Bootstrap the application
│   └── styles.css              # Global styles
├── angular.json                # Angular CLI configuration
├── package.json                # npm dependencies and scripts
└── tsconfig.json               # TypeScript configuration
```

---

## 2. 🛠️ **Angular CLI Commands**

Angular CLI is a powerful tool to initialize, develop, scaffold, and maintain Angular applications.

| **Command**                                   | **Description**                                                                 |
|-----------------------------------------------|---------------------------------------------------------------------------------|
| `ng new <project-name>`                       | Creates a new Angular project.                                                  |
| `ng serve` / `ng s`                            | Serves the application locally and watches for changes.                        |
| `ng generate component <component-name>`       | Generates a new component.                                                      |
| `ng generate directive <directive-name>`       | Generates a new directive.                                                      |
| `ng generate service <service-name>`           | Generates a new service.                                                        |
| `ng generate module <module-name>`             | Generates a new module.                                                         |
| `ng build`                                     | Builds the application for production.                                         |
| `ng test`                                      | Runs unit tests using Karma.                                                    |
| `ng e2e`                                       | Runs end-to-end tests using Protractor or Cypress.                             |
| `ng add <package>`                             | Adds a package to your project (e.g., Angular Material).                        |
| `ng update`                                    | Updates Angular and its dependencies to the latest version.                     |
| `ng lint`                                      | Runs linting tools on your project’s code.                                     |
| `ng version` / `ng v`                           | Displays Angular CLI version and other environment details.                     |

**Examples:**

- **Create a new project:**
  ```bash
  ng new my-app
  ```

- **Serve the application:**
  ```bash
  cd my-app
  ng serve --open
  ```

- **Generate a new component:**
  ```bash
  ng generate component navbar
  # or shorthand
  ng g c navbar
  ```

---

## 3. 🧩 **Components**

Components are the building blocks of Angular applications, controlling a portion of the screen called a view.

### **Component Structure**

```typescript
// example.component.ts
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-example',                  // Custom HTML tag
  templateUrl: './example.component.html',  // HTML template
  styleUrls: ['./example.component.css']    // Component-specific styles
})
export class ExampleComponent implements OnInit {
  title: string = 'Hello Angular';

  constructor() { }

  ngOnInit(): void {
    // Initialization logic
  }

  greet() {
    alert(this.title);
  }
}
```

### **Component Template**

```html
<!-- example.component.html -->
<div>
  <h1>{{ title }}</h1>
  <button (click)="greet()">Greet</button>
</div>
```

### **Usage in HTML**

```html
<!-- parent.component.html -->
<app-example></app-example>
```

---

## 4. 🔗 **Data Binding**

Angular provides several ways to bind data between the component class and the template.

### **1. Interpolation**

- **Syntax:** `{{ expression }}`

- **Example:**

  ```html
  <p>Welcome, {{ username }}!</p>
  ```

### **2. Property Binding**

- **Syntax:** `[property]="expression"`

- **Example:**

  ```html
  <img [src]="imageUrl" alt="User Image">
  ```

### **3. Event Binding**

- **Syntax:** `(event)="handler"`

- **Example:**

  ```html
  <button (click)="onClick()">Click Me</button>
  ```

### **4. Two-Way Binding**

- **Syntax:** `[(ngModel)]="property"`

- **Requirements:** Import `FormsModule` in your module.

- **Example:**

  ```html
  <input [(ngModel)]="userInput" placeholder="Enter text">
  <p>You entered: {{ userInput }}</p>
  ```

- **Note:** Two-way binding is a combination of property and event binding.

---

## 5. 🧰 **Directives**

Directives are classes that add additional behavior to elements in your Angular applications.

### **Types of Directives**

1. **Components**: Directives with a template.
2. **Structural Directives**: Change the DOM layout by adding or removing elements (e.g., `*ngIf`, `*ngFor`).
3. **Attribute Directives**: Change the appearance or behavior of an element (e.g., `ngClass`, `ngStyle`).

### **Creating a Custom Attribute Directive**

```typescript
// highlight.directive.ts
import { Directive, ElementRef, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[appHighlight]'  // Usage: <p appHighlight>...</p>
})
export class HighlightDirective {
  @Input() appHighlight: string = 'yellow'; // Default highlight color

  constructor(private el: ElementRef) { }

  @HostListener('mouseenter') onMouseEnter() {
    this.highlight(this.appHighlight);
  }

  @HostListener('mouseleave') onMouseLeave() {
    this.highlight('');
  }

  private highlight(color: string) {
    this.el.nativeElement.style.backgroundColor = color;
  }
}
```

### **Usage**

```html
<p appHighlight="lightblue">Hover over me to see a highlight!</p>
```

### **Common Built-in Directives**

- **Structural:**
  - `*ngIf`
  - `*ngFor`
  - `*ngSwitch`
  
- **Attribute:**
  - `ngClass`
  - `ngStyle`
  - `ngModel`

---

## 6. 🪄 **Pipes**

Pipes transform displayed values within a template.

### **Using Built-in Pipes**

```html
<!-- example.component.html -->
<p>Original Date: {{ today }}</p>
<p>Formatted Date: {{ today | date:'fullDate' }}</p>
<p>Uppercase Text: {{ text | uppercase }}</p>
```

### **Common Built-in Pipes**

- `DatePipe`: Formats dates.
- `UpperCasePipe`: Transforms text to uppercase.
- `LowerCasePipe`: Transforms text to lowercase.
- `CurrencyPipe`: Formats numbers as currency.
- `DecimalPipe`: Formats numbers with decimal points.
- `PercentPipe`: Formats numbers as percentages.

### **Creating a Custom Pipe**

```typescript
// reverse.pipe.ts
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'reverse'
})
export class ReversePipe implements PipeTransform {
  transform(value: string): string {
    return value.split('').reverse().join('');
  }
}
```

### **Usage**

```html
<p>Reversed: {{ 'Angular' | reverse }}</p> <!-- Output: ralugnA -->
```

---

## 7. 🛎️ **Services & Dependency Injection**

Services provide a way to share data and functionality across components. Dependency Injection (DI) is a design pattern used to supply dependencies to classes.

### **Creating a Service**

```typescript
// data.service.ts
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'  // Singleton service available application-wide
})
export class DataService {
  private data: string[] = [];

  constructor() { }

  addData(item: string) {
    this.data.push(item);
  }

  getData(): string[] {
    return this.data;
  }
}
```

### **Injecting a Service into a Component**

```typescript
// example.component.ts
import { Component, OnInit } from '@angular/core';
import { DataService } from '../services/data.service';

@Component({
  selector: 'app-example',
  templateUrl: './example.component.html',
  styleUrls: ['./example.component.css']
})
export class ExampleComponent implements OnInit {
  items: string[] = [];
  newItem: string = '';

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.items = this.dataService.getData();
  }

  addItem() {
    if (this.newItem.trim()) {
      this.dataService.addData(this.newItem.trim());
      this.newItem = '';
      this.items = this.dataService.getData();
    }
  }
}
```

### **Usage in Template**

```html
<!-- example.component.html -->
<input [(ngModel)]="newItem" placeholder="Add item">
<button (click)="addItem()">Add</button>
<ul>
  <li *ngFor="let item of items">{{ item }}</li>
</ul>
```

---

## 8. 🚦 **Routing**

Routing enables navigation between different views/components in a single-page application.

### **Setting Up Routing**

1. **Generate Routing Module (if not already created):**
   ```bash
   ng generate module app-routing --flat --module=app
   ```

2. **Define Routes:**

   ```typescript
   // app-routing.module.ts
   import { NgModule } from '@angular/core';
   import { RouterModule, Routes } from '@angular/router';
   import { HomeComponent } from './home/home.component';
   import { AboutComponent } from './about/about.component';
   import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

   const routes: Routes = [
     { path: '', component: HomeComponent },
     { path: 'about', component: AboutComponent },
     { path: '**', component: PageNotFoundComponent }  // Wildcard route for a 404 page
   ];

   @NgModule({
     imports: [RouterModule.forRoot(routes)],
     exports: [RouterModule]
   })
   export class AppRoutingModule { }
   ```

3. **Add `<router-outlet>` in App Component Template:**

   ```html
   <!-- app.component.html -->
   <nav>
     <a routerLink="/">Home</a>
     <a routerLink="/about">About</a>
   </nav>
   <router-outlet></router-outlet>
   ```

### **Navigating Programmatically**

```typescript
// example.component.ts
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-example',
  template: `<button (click)="goToAbout()">Go to About</button>`
})
export class ExampleComponent {
  constructor(private router: Router) { }

  goToAbout() {
    this.router.navigate(['/about']);
  }
}
```

### **Lazy Loading Modules**

```typescript
// app-routing.module.ts
const routes: Routes = [
  { path: 'feature', loadChildren: () => import('./feature/feature.module').then(m => m.FeatureModule) }
];
```

---

## 9. 📝 **Forms**

Angular supports two types of forms: **Template-Driven** and **Reactive**.

### **1. Template-Driven Forms**

Suitable for simple forms with straightforward validation.

#### **Setup**

- **Import `FormsModule`:**

  ```typescript
  // app.module.ts
  import { FormsModule } from '@angular/forms';

  @NgModule({
    imports: [
      // other imports
      FormsModule
    ],
    // ...
  })
  export class AppModule { }
  ```

#### **Example**

```html
<!-- template-driven-form.component.html -->
<form #form="ngForm" (ngSubmit)="onSubmit(form)">
  <input name="username" ngModel required placeholder="Username">
  <input name="email" ngModel type="email" required placeholder="Email">
  <button type="submit" [disabled]="form.invalid">Submit</button>
</form>
```

```typescript
// template-driven-form.component.ts
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-template-driven-form',
  templateUrl: './template-driven-form.component.html'
})
export class TemplateDrivenFormComponent {

  onSubmit(form: NgForm) {
    if (form.valid) {
      console.log(form.value);
    }
  }
}
```

### **2. Reactive Forms**

Ideal for complex forms with dynamic validation and more control over form state.

#### **Setup**

- **Import `ReactiveFormsModule`:**

  ```typescript
  // app.module.ts
  import { ReactiveFormsModule } from '@angular/forms';

  @NgModule({
    imports: [
      // other imports
      ReactiveFormsModule
    ],
    // ...
  })
  export class AppModule { }
  ```

#### **Example**

```typescript
// reactive-form.component.ts
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html'
})
export class ReactiveFormComponent implements OnInit {
  form: FormGroup;

  ngOnInit() {
    this.form = new FormGroup({
      username: new FormControl('', [Validators.required, Validators.minLength(4)]),
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', Validators.required)
    });
  }

  onSubmit() {
    if (this.form.valid) {
      console.log(this.form.value);
    }
  }
}
```

```html
<!-- reactive-form.component.html -->
<form [formGroup]="form" (ngSubmit)="onSubmit()">
  <input formControlName="username" placeholder="Username">
  <div *ngIf="form.get('username')?.invalid && form.get('username')?.touched">
    Username is required and should be at least 4 characters.
  </div>

  <input formControlName="email" type="email" placeholder="Email">
  <div *ngIf="form.get('email')?.invalid && form.get('email')?.touched">
    Valid email is required.
  </div>

  <input formControlName="password" type="password" placeholder="Password">
  <div *ngIf="form.get('password')?.invalid && form.get('password')?.touched">
    Password is required.
  </div>

  <button type="submit" [disabled]="form.invalid">Submit</button>
</form>
```

---

## 10. 🌐 **HTTP Client**

Angular's `HttpClient` module allows you to communicate with backend services over HTTP.

### **Setup**

- **Import `HttpClientModule`:**

  ```typescript
  // app.module.ts
  import { HttpClientModule } from '@angular/common/http';

  @NgModule({
    imports: [
      // other imports
      HttpClientModule
    ],
    // ...
  })
  export class AppModule { }
  ```

### **Creating an HTTP Service**

```typescript
// api.service.ts
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = 'https://api.example.com/items';

  constructor(private http: HttpClient) { }

  // GET request
  getItems(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl)
      .pipe(
        retry(3),                        // Retry up to 3 times before failing
        catchError(this.handleError)     // Handle errors
      );
  }

  // POST request
  addItem(item: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, item)
      .pipe(
        catchError(this.handleError)
      );
  }

  // Error handling
  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // Client-side or network error
      console.error('An error occurred:', error.error.message);
    } else {
      // Backend returned an unsuccessful response code
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // Return observable with user-facing error message
    return throwError('Something went wrong; please try again later.');
  }
}
```

### **Using the Service in a Component**

```typescript
// items.component.ts
import { Component, OnInit } from '@angular/core';
import { ApiService } from '../services/api.service';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html'
})
export class ItemsComponent implements OnInit {
  items: any[] = [];
  newItem: string = '';

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.fetchItems();
  }

  fetchItems() {
    this.apiService.getItems().subscribe(
      data => this.items = data,
      error => console.error(error)
    );
  }

  addItem() {
    if (this.newItem.trim()) {
      const item = { name: this.newItem.trim() };
      this.apiService.addItem(item).subscribe(
        res => {
          this.items.push(res);
          this.newItem = '';
        },
        error => console.error(error)
      );
    }
  }
}
```

```html
<!-- items.component.html -->
<div>
  <input [(ngModel)]="newItem" placeholder="Add new item">
  <button (click)="addItem()">Add</button>
</div>
<ul>
  <li *ngFor="let item of items">{{ item.name }}</li>
</ul>
```

---

## 11. 🔄 **Lifecycle Hooks**

Lifecycle hooks allow you to tap into key moments in a component's lifecycle.

| **Hook**           | **Description**                                                       |
|--------------------|-----------------------------------------------------------------------|
| `ngOnChanges`      | Called before `ngOnInit` and whenever one or more data-bound properties change. |
| `ngOnInit`         | Called once after the first `ngOnChanges`. Ideal for component initialization. |
| `ngDoCheck`        | Called during every change detection run. Useful for custom change detection. |
| `ngAfterContentInit` | Called after content (ng-content) has been projected into view.       |
| `ngAfterContentChecked` | Called after every check of projected content.                   |
| `ngAfterViewInit`  | Called after the component's view and its child views have been initialized. |
| `ngAfterViewChecked` | Called after every check of the component's view and child views.  |
| `ngOnDestroy`      | Called just before Angular destroys the component. Use for cleanup.   |

### **Example: Using `ngOnInit` and `ngOnDestroy`**

```typescript
// lifecycle.component.ts
import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-lifecycle',
  template: `<p>Lifecycle Component</p>`
})
export class LifecycleComponent implements OnInit, OnDestroy {

  constructor() { }

  ngOnInit(): void {
    console.log('Component Initialized');
    // Initialization logic here
  }

  ngOnDestroy(): void {
    console.log('Component Destroyed');
    // Cleanup logic here
  }
}
```

---

## 12. 📦 **Modules**

Modules help organize an Angular application into cohesive blocks of functionality.

### **NgModule Structure**

```typescript
// example.module.ts
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ExampleComponent } from './example/example.component';
import { ExampleService } from './services/example.service';

@NgModule({
  declarations: [ExampleComponent],  // Components, directives, pipes
  imports: [CommonModule],            // Other modules
  providers: [ExampleService],        // Services
  exports: [ExampleComponent]         // Exported components, directives, pipes
})
export class ExampleModule { }
```

### **Feature Modules vs. Shared Modules**

- **Feature Modules:** Encapsulate related components, services, etc., for a specific feature.
- **Shared Modules:** Contain common components, directives, and pipes used across the application.

### **Lazy Loaded Modules**

Defined in routing configuration to load only when the route is accessed.

---

## 13. 🛠️ **Commonly Used Built-in Directives**

| **Directive**        | **Type**           | **Description**                                        | **Syntax Example**                  |
|----------------------|--------------------|--------------------------------------------------------|-------------------------------------|
| `*ngIf`              | Structural         | Conditionally includes a template based on truthiness.| `<div *ngIf="isVisible">Content</div>` |
| `*ngFor`             | Structural         | Repeats a template for each item in a collection.      | `<li *ngFor="let item of items">{{ item }}</li>` |
| `*ngSwitch`          | Structural         | Conditionally displays elements based on matching value.| `<div [ngSwitch]="condition">...</div>` |
| `[ngClass]`          | Attribute          | Adds or removes CSS classes dynamically.               | `<div [ngClass]="{'active': isActive}">Content</div>` |
| `[ngStyle]`          | Attribute          | Sets inline styles dynamically.                        | `<div [ngStyle]="{'color': textColor}">Content</div>` |
| `[ngModel]`          | Attribute          | Two-way data binding for form inputs.                  | `<input [(ngModel)]="username">`    |
| `[routerLink]`       | Attribute          | Navigation link to routes.                             | `<a [routerLink]="['/about']">About</a>` |

---

## 14. 🧪 **Commonly Used Built-in Pipes**

| **Pipe**             | **Description**                                      | **Syntax Example**                    |
|----------------------|------------------------------------------------------|---------------------------------------|
| `date`               | Formats a date value according to locale rules.      | `{{ today | date:'shortDate' }}`       |
| `uppercase`          | Transforms text to uppercase.                        | `{{ 'hello' | uppercase }}`           |
| `lowercase`          | Transforms text to lowercase.                        | `{{ 'HELLO' | lowercase }}`           |
| `currency`           | Formats a number as currency.                         | `{{ price | currency:'USD' }}`         |
| `percent`            | Formats a number as a percentage.                     | `{{ ratio | percent }}`                |
| `json`               | Converts a value into a JSON string.                  | `{{ data | json }}`                    |
| `slice`              | Creates a new array or string containing a subset.    | `{{ text | slice:1:4 }}`               |
| `keyvalue`           | Transforms Object or Map into an array of key-value pairs.| `*ngFor="let item of object | keyvalue"` |
| `async`              | Unwraps a value from an Observable or Promise.        | `{{ observable$ | async }}`            |

---

## 15. ✅ **Best Practices**

1. **Component-Based Architecture:**
   - Keep components small and focused.
   - Reuse components where possible.

2. **Separation of Concerns:**
   - Use services for business logic and data management.
   - Keep UI logic within components.

3. **Use Strong Typing with TypeScript:**
   - Define interfaces for data models.
   - Utilize TypeScript's type system to catch errors early.

4. **Organize Code with Modules:**
   - Group related functionalities.
   - Implement feature and shared modules.

5. **Lazy Load Modules:**
   - Improve performance by loading modules only when needed.

6. **Use Angular CLI:**
   - Leverage CLI commands for scaffolding, building, and testing.

7. **Implement Proper Error Handling:**
   - Handle HTTP errors gracefully.
   - Provide user-friendly error messages.

8. **Optimize Performance:**
   - Use `ChangeDetectionStrategy.OnPush` when applicable.
   - Avoid unnecessary bindings and computations.

9. **Secure Your Application:**
   - Sanitize user inputs.
   - Avoid using `innerHTML` unless necessary and safe.

10. **Write Unit and E2E Tests:**
    - Ensure code reliability and prevent regressions.

11. **Consistent Coding Standards:**
    - Follow Angular Style Guide.
    - Use linters and formatters (e.g., TSLint, Prettier).

12. **Documentation:**
    - Comment complex logic.
    - Maintain up-to-date documentation.

---

## 16. 📚 **Useful Resources**

- **Official Documentation:**
  - [Angular Official Docs](https://angular.io/docs)

- **Tutorials:**
  - [Tour of Heroes](https://angular.io/tutorial)
  - [Angular - The Complete Guide (Udemy)](https://www.udemy.com/course/the-complete-guide-to-angular-2/)

- **Books:**
  - *"Angular Up & Running"* by Shyam Seshadri
  - *"Pro Angular"* by Adam Freeman

- **YouTube Channels:**
  - [Academind](https://www.youtube.com/channel/UCSJbGtTlrDami-tDGPUV9-w)
  - [Traversy Media](https://www.youtube.com/user/TechGuyWeb)
  - [Fireship](https://www.youtube.com/channel/UCsBjURrPoezykLs9EqgamOA)

- **Online Platforms:**
  - [StackBlitz](https://stackblitz.com/) - Online IDE for Angular projects.
  - [CodeSandbox](https://codesandbox.io/) - Another online IDE supporting Angular.

- **Communities:**
  - [Angular Reddit Community](https://www.reddit.com/r/angular/)
  - [Stack Overflow - Angular Tag](https://stackoverflow.com/questions/tagged/angular)
  - [Angular Discord Servers](https://discord.com/invite/angular)

---

## 📌 **Quick Code Snippets**

### **1. Creating a New Component**

```bash
ng generate component user-profile
# or shorthand
ng g c user-profile
```

### **2. Binding a Property**

```html
<!-- user-profile.component.html -->
<img [src]="user.avatarUrl" alt="{{ user.name }}">
```

### **3. Handling a Click Event**

```html
<!-- user-profile.component.html -->
<button (click)="updateProfile()">Update Profile</button>
```

```typescript
// user-profile.component.ts
updateProfile() {
  // Update logic here
}
```

### **4. Using `*ngFor` to Display a List**

```html
<!-- user-list.component.html -->
<ul>
  <li *ngFor="let user of users">{{ user.name }}</li>
</ul>
```

### **5. Fetching Data with HTTP Client**

```typescript
// user.service.ts
getUsers(): Observable<User[]> {
  return this.http.get<User[]>(this.apiUrl)
    .pipe(
      catchError(this.handleError)
    );
}
```

```typescript
// user-list.component.ts
ngOnInit() {
  this.userService.getUsers().subscribe(
    data => this.users = data,
    error => console.error(error)
  );
}
```

### **6. Implementing a Route Guard**

```typescript
// auth.guard.ts
import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private authService: AuthService, private router: Router) { }

  canActivate(): boolean {
    if(this.authService.isLoggedIn()) {
      return true;
    } else {
      this.router.navigate(['/login']);
      return false;
    }
  }
}
```

```typescript
// app-routing.module.ts
const routes: Routes = [
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard] },
  // other routes
];
```

---

## 🎯 **Summary**

This Angular Cheat Sheet provides a concise overview of essential Angular concepts, commands, and best practices. Use it as a quick reference while developing Angular applications to enhance productivity and maintain code quality. For deeper understanding and advanced topics, refer to the [Official Angular Documentation](https://angular.io/docs) and other recommended resources.

Happy Coding! 🚀